package com.zp.basic.notice.biz.impl;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zp.basic.email.model.Email;
import com.zp.basic.email.service.EmailService;
import com.zp.basic.email.vo.CheckEmailVo;
import com.zp.basic.feign.user.client.UserFeignClient;
import com.zp.basic.feign.user.dto.UserDto;
import com.zp.basic.notice.biz.NoticeBiz;
import com.zp.basic.notice.model.Notice;
import com.zp.basic.notice.request.CheckTheNoticeRequest;
import com.zp.basic.notice.request.NoticePageRequest;
import com.zp.basic.notice.request.SendEmailRequest;
import com.zp.basic.notice.service.NoticeService;
import com.zp.basic.notice.vo.FileVo;
import com.zp.basic.notice.vo.NoticePageVo;
import com.zp.util.general.exception.ZfException;
import com.zp.util.general.response.CommonResponse;
import com.zp.util.general.util.BeanUtil;
import com.zp.util.general.util.ContextUtils;
import com.zp.util.general.util.DateUtils;
import com.zp.util.general.util.OssUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotEmpty;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author zp
 * @create 2022/1/19 12:13
 * @desc 消息核心业务实现层
 **/
@Service
public class NoticeBizImpl implements NoticeBiz {

    private NoticeService noticeService;
    private UserFeignClient userFeignClient;
    private EmailService emailService;

    public NoticeBizImpl(NoticeService noticeService, UserFeignClient userFeignClient, EmailService emailService) {
        this.noticeService = noticeService;
        this.userFeignClient = userFeignClient;
        this.emailService = emailService;
    }

    @Override
    public Map<String, Object> selectPageNotice(NoticePageRequest noticePageRequest) {
        //获取uid
        String userId = ContextUtils.getUserId();
        Assert.hasLength(userId, "该用户不存在");
        noticePageRequest.setUserId(userId);
        //设置开始时间、结束时间
        if (!CollectionUtils.isEmpty(noticePageRequest.getCreateTime())) {
            noticePageRequest.setBeginDate(noticePageRequest.getCreateTime().get(0));
            noticePageRequest.setEndDate(noticePageRequest.getCreateTime().get(1));
        }
        IPage<NoticePageVo> noticePage = new Page<>(noticePageRequest.getPageIndex(), noticePageRequest.getPageSize());
        IPage<NoticePageVo> noticeIPage = noticeService.selectPageNotice(noticePage, noticePageRequest);
        return CommonResponse.setResponseData(noticeIPage);
    }

    @Override
    @Transactional
    public Map<String, Object> sendEmail(SendEmailRequest sendEmailRequest) {
        String eId = UUID.randomUUID().toString();
        //保存消息
        this.saveNotice(eId, sendEmailRequest);
        //保存信件
        this.saveEmail(eId, sendEmailRequest);

        return CommonResponse.setResponseData(null);
    }

    @Override
    public Map<String, Object> uploadFile(MultipartFile file) {
        String filePath;
        FileVo fileVo = new FileVo();
        try {
            //获取文件全名
            String originalFilename = file.getOriginalFilename();
            //生成OSS上传全路径
            filePath = OssUtil.getFilePath(originalFilename);
            InputStream inputStream = file.getInputStream();
            OssUtil.upload(filePath, inputStream);
            fileVo.setName(originalFilename);
            fileVo.setUrl(OssUtil.HEADER + filePath);
        } catch (IOException e) {
            e.printStackTrace();
            throw new ZfException("文件流转换失败");
        }
        return CommonResponse.setResponseData(fileVo);
    }

    @Override
    public Map<String, Object> setAllHaveBeenRead() {
        String userId = ContextUtils.getUserId();
        noticeService.setAllHaveBeenReadByUserId(userId);
        return CommonResponse.setResponseData(null);
    }

    @Override
    @Transactional
    public Map<String, Object> deleteNoticeByNoticeIds(String[] nId) {
        List<String> ids = Arrays.asList(nId);
        List<Notice> noticeList = noticeService.selectNotices(ids);
        //删除消息
        noticeService.deleteNoticeByNoticeIds(ids);
        //删除信件
        this.deleteEmail(noticeList, ids);
        return CommonResponse.setResponseData(null);
    }

    @Override
    public Map<String, Object> checkTheNotice(CheckTheNoticeRequest checkTheNoticeRequest) {
        String nId = checkTheNoticeRequest.getnId();
        String eId = checkTheNoticeRequest.geteId();
        Email email = emailService.selectEmailByEmailId(eId);
        Assert.notNull(email, "不存在该信件");
        String fileJson = email.getFileJson();
        CheckEmailVo checkEmailVo = new CheckEmailVo();
        checkEmailVo.setEmailTopic(email.geteTopic());
        checkEmailVo.setEmailContent(email.geteContent());
        if (StringUtils.isNotBlank(fileJson)) {
            List<FileVo> fileVos = JSON.parseArray(fileJson, FileVo.class);
            checkEmailVo.setFileVos(fileVos);
        }
        //更新为已读
        Notice notice = noticeService.findNoticeById(nId);
        notice.setHaveRead("1");
        noticeService.updateNotice(notice);
        return CommonResponse.setResponseData(checkEmailVo);
    }

    @Override
    public Map<String, Object> getNotReadNoticeNum() {
        String userId = ContextUtils.getUserId();
        Integer num = noticeService.getNotReadNoticeNum(userId);
        return CommonResponse.setResponseData(num);
    }

    private void deleteEmail(List<Notice> noticeList, List<String> ids) {
        //查出消息下所有信件
        List<String> emailIds = noticeList.stream().map(notice -> notice.geteId()).collect(Collectors.toList());
        //删除信件
        emailService.deleteByEmailIds(emailIds);
    }


    private void saveEmail(String eId, SendEmailRequest sendEmailRequest) {
        Email email = new Email();
        email.seteId(eId);
        email.seteContent(sendEmailRequest.getEmailContent());
        email.seteTopic(sendEmailRequest.getEmailTopic());
        if (!CollectionUtils.isEmpty(sendEmailRequest.getFileVoList())) {
            String json = JSONObject.toJSONString(sendEmailRequest.getFileVoList());
            email.setFileJson(json);//设置附件名称、地址
        }
        emailService.saveEmail(email);
    }

    private void saveNotice(String eId, SendEmailRequest sendEmailRequest) {
        Notice notice = new Notice();
        String userId = ContextUtils.getUserId();
        Assert.hasLength(userId, "该用户不存在");
        String receiveMan = sendEmailRequest.getReceiveMan();
        sendEmailRequest.setUserId(userId);
        //判断收件人是否存在
        Object o = userFeignClient.findUserByUid(receiveMan);
        Assert.notNull(o, "收件人【" + receiveMan + "】不存在");
        notice.seteId(eId);
        notice.setSendMan(userId);
        notice.setReceiveMan(receiveMan);
        notice.setHaveRead("0");
        noticeService.saveNotice(notice);
    }
}
