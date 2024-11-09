package com.zp.basic.notice.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zp.basic.notice.model.Notice;
import com.zp.basic.notice.request.NoticePageRequest;
import com.zp.basic.notice.vo.NoticePageVo;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**

 * @author  zp

 * @create  2022/1/19 21:34

 * @desc    站内信持久层

 **/
@Repository
public interface NoticeMapper extends BaseMapper<Notice> {
    /**
     * 分页 查找站内信
     * @param noticePage
     * @param noticePageRequest
     * @return
     */
    IPage<NoticePageVo> selectPageNotice(@Param("noticePage") IPage<NoticePageVo> noticePage, @Param("noticePageRequest") NoticePageRequest noticePageRequest);

    /**
     * 根据用户ID消息全部已读
     * @param userId
     */
    void setAllHaveBeenReadByUserId(String userId);
}


