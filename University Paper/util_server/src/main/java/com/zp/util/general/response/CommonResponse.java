package com.zp.util.general.response;


import com.zp.util.general.enums.StatusEnum;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**

 * @author  zp

 * @create  2021/7/21 10:58

 * @desc    相应枚举类

 **/
@Component
public class CommonResponse {
    public static Map setPageResponse(Object data, Integer recordsTotal, String responseCode, String responseMsg, boolean status) {
        Map<String, Object> responseResult = new HashMap<>();
        responseResult.put("data", data);// 响应数据
        responseResult.put("count", recordsTotal);//条数
        responseResult.put("code", responseCode);// 响应码
        responseResult.put("msg", responseMsg);// 响应提示信息
        responseResult.put("status", status); // 响应状态
        return responseResult;
    }

    public static Map setResponseData(Object data, String code, String msg, boolean status) {
        Map<String, Object> responseResult = new HashMap<>();
        responseResult.put("status", status); // 响应状态
        responseResult.put("code", code); // 响应码
        responseResult.put("msg", msg); // 响应提示信息
        responseResult.put("data", data); // 响应数据
        return responseResult;
    }


    public static Map setIndexPageResponse(Object data, Integer recordsTotal) {
        return setPageResponse(data, recordsTotal,
                StatusEnum.SUCCESS.getFlag(), "查询成功", true );
    }

    public static Map setResponseData(Object data) {
        return setResponseData(data, StatusEnum.SUCCESS.getFlag(), "操作成功", true);
    }
    public static Map setResponseMsg(String msg) {
        return setResponseData(null,  StatusEnum.SUCCESS.getFlag(), msg, true);
    }
}
