package com.zp.basic.notice.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zp.basic.notice.model.Notice;
import com.zp.basic.notice.request.NoticePageRequest;
import com.zp.basic.notice.vo.NoticePageVo;

import java.util.List;

/**

 * @author  zp

 * @create  2022/1/19 21:29

 * @desc    站内信通用业务层

 **/
public interface NoticeService {
    /**
     * 分页查找站内信
     * @param noticePage
     * @param noticePageRequest
     * @return
     */
    IPage<NoticePageVo> selectPageNotice(IPage<NoticePageVo> noticePage, NoticePageRequest noticePageRequest);

    /**
     * 保存站内信
     * @param notice
     */
    void saveNotice(Notice notice);

    /**
     * 根据用户ID设置全部信件为已读
     * @param userId
     */
    void setAllHaveBeenReadByUserId(String userId);

    /**
     * 根据nid删除消息
     * @param nIds
     */
    void deleteNoticeByNoticeIds(List<String> nIds);

    /**
     * 根据nid查找消息
     * @param ids
     */
    List<Notice> selectNotices(List<String> ids);


    /**
     * 根据ID查询单个notice
     * @param nId
     */
    Notice findNoticeById(String nId);

    /**
     * 更新notice
     * @param notice
     */
    void updateNotice(Notice notice);

    /**
     * 获取未读消息数量
     * @param userId
     * @return
     */
    Integer getNotReadNoticeNum(String userId);
}
