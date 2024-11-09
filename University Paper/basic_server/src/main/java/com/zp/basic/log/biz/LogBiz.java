package com.zp.basic.log.biz;

import com.zp.basic.log.dto.ActionDto;
import com.zp.basic.log.dto.LogDto;
import com.zp.basic.log.request.FunctionLogRequest;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.Map;

/**

 * @author  zp

 * @create  2022/1/16 17:19

 * @desc    日志业务层

 **/
@Validated
public interface LogBiz {
    /**
     * 动态分页查询功能日志
     * @param functionLogRequest
     * @return
     */
    Map<String, Object> selectPageFunctionLog(FunctionLogRequest functionLogRequest);

    /**
     * 初始化事件下拉选择框
     * @return
     */
    Map<String, Object> getSelectOption();

    /**
     * 动态分页查询登录日志
     * @param functionLogRequest
     * @return
     */
    Map<String, Object> selectPageLoginLog(FunctionLogRequest functionLogRequest);

    /**
     * 保存日志
     * @param logDto
     * @return
     */
    Map<String, Object> saveLog(@Valid LogDto logDto);

    /**
     * 保存功能日志
     * @param functionId
     * @return
     */
    Map<String, Object> saveFunLog(@NotBlank(message = "functionId不能为空") String functionId);
}
