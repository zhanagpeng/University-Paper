package com.zp.basic.notice.biz;

import com.zp.basic.notice.request.CheckTheNoticeRequest;
import com.zp.basic.notice.request.NoticePageRequest;
import com.zp.basic.notice.request.SendEmailRequest;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Map;

/**
 * @author zp
 * @create 2022/1/19 12:12
 * @desc 消息核心业务层
 **/
@Validated
public interface NoticeBiz {
    /**
     * 分页查询站内信
     *
     * @param noticePageRequest
     * @return
     */
    Map<String, Object> selectPageNotice(@Valid NoticePageRequest noticePageRequest);

    /**
     * 发送信件
     *
     * @param sendEmailRequest
     * @return
     */
    Map<String, Object> sendEmail(@Valid SendEmailRequest sendEmailRequest);

    /**
     * 上传文件至OSS
     *
     * @param file
     * @return
     */
    Map<String, Object> uploadFile(@NotNull(message = "上传文件不能为空") MultipartFile file);

    /**
     * 设置全部已读
     *
     * @return
     */
    Map<String, Object> setAllHaveBeenRead();

    /**
     * 删除消息
     *
     * @param nId
     * @return
     */
    Map<String, Object> deleteNoticeByNoticeIds(@NotEmpty(message = "nId不能为空") String[] nId);

    /**
     * 查看消息
     * @param checkTheNoticeRequest
     * @return
     */
    Map<String, Object> checkTheNotice(@Valid CheckTheNoticeRequest checkTheNoticeRequest);

    /**
     * 获取未读消息
     * @return
     */
    Map<String, Object> getNotReadNoticeNum();
}
