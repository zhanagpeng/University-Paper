package com.zp.basic.log.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zp.basic.log.dto.ActionDto;
import com.zp.basic.log.mapper.LogMapper;
import com.zp.basic.log.model.Log;
import com.zp.basic.log.request.FunctionLogRequest;
import com.zp.basic.log.service.LogService;
import com.zp.basic.log.vo.FunctionLogPageVo;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zp
 * @create 2022/1/16 17:20
 * @desc 日志通用业务实现层
 **/
@Service
public class LogServiceImpl implements LogService {

    private LogMapper logMapper;

    public LogServiceImpl(LogMapper logMapper) {
        this.logMapper = logMapper;
    }

    @Override
    public IPage<FunctionLogPageVo> selectPageFunctionLog(IPage<FunctionLogPageVo> logPage, FunctionLogRequest functionLogRequest) {
        return logMapper.selectPageFunctionLog(logPage, functionLogRequest);
    }

    @Override
    public IPage<FunctionLogPageVo> selectPageLoginLog(IPage<FunctionLogPageVo> logPage, FunctionLogRequest functionLogRequest) {
        return logMapper.selectPageLoginLog(logPage, functionLogRequest);
    }

    @Override
    public void saveLog(Log log) {
        logMapper.insert(log);
    }


}
