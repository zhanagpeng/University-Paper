package com.zp.basic.notice.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zp.basic.notice.mapper.NoticeMapper;
import com.zp.basic.notice.model.Notice;
import com.zp.basic.notice.request.NoticePageRequest;
import com.zp.basic.notice.service.NoticeService;
import com.zp.basic.notice.vo.NoticePageVo;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * @author zp
 * @create 2022/1/19 21:30
 * @desc 站内信通用业务实现层
 **/
@Service
public class NoticeServiceImpl implements NoticeService {
    private NoticeMapper noticeMapper;

    public NoticeServiceImpl(NoticeMapper noticeMapper) {
        this.noticeMapper = noticeMapper;
    }

    @Override
    public IPage<NoticePageVo> selectPageNotice(IPage<NoticePageVo> noticePage, NoticePageRequest noticePageRequest) {
        IPage<NoticePageVo> noticePageVoIPage = noticeMapper.selectPageNotice(noticePage, noticePageRequest);
        return noticePageVoIPage;
    }

    @Override
    public void saveNotice(Notice notice) {
        noticeMapper.insert(notice);
    }

    @Override
    public void setAllHaveBeenReadByUserId(String userId) {
        noticeMapper.setAllHaveBeenReadByUserId(userId);
    }

    @Override
    public void deleteNoticeByNoticeIds(List<String> nIds) {
        noticeMapper.deleteBatchIds(nIds);
    }

    @Override
    public List<Notice> selectNotices(List<String> ids) {
        return noticeMapper.selectBatchIds(ids);
    }

    @Override
    public Notice findNoticeById(String nId) {
        return noticeMapper.selectById(nId);
    }

    @Override
    public void updateNotice(Notice notice) {
        noticeMapper.updateById(notice);
    }

    @Override
    public Integer getNotReadNoticeNum(String userId) {
        QueryWrapper<Notice> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(Notice.RECEIVE_MAN,userId);
        queryWrapper.eq(Notice.HAVE_READ,"0");
        return noticeMapper.selectCount(queryWrapper);
    }
}
