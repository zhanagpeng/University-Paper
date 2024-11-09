package com.zp.basic.log.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zp.basic.log.dto.ActionDto;
import com.zp.basic.log.model.Log;
import com.zp.basic.log.request.FunctionLogRequest;
import com.zp.basic.log.vo.FunctionLogPageVo;

import java.util.List;

/**

 * @author  zp

 * @create  2022/1/16 17:20

 * @desc    日志通用业务层

 **/
public interface LogService {
    /**
     * 动态分页查询功能日志
     * @param logPage
     * @param functionLogRequest
     * @return
     */
    IPage<FunctionLogPageVo> selectPageFunctionLog(IPage<FunctionLogPageVo> logPage, FunctionLogRequest functionLogRequest);

    /**
     * 动态分页查询登录日志
     * @param logPage
     * @param functionLogRequest
     * @return
     */
    IPage<FunctionLogPageVo> selectPageLoginLog(IPage<FunctionLogPageVo> logPage, FunctionLogRequest functionLogRequest);

    /**
     * 保存日志
     * @param log
     */
    void saveLog(Log log);
}
