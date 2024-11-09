package com.zp.gateway.common;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author zp
 * @create 2021/7/20 16:26
 * @desc 白名单初始化
 **/
@Component
public class WhiteListInIt {
    public static List<String> whiteList = new ArrayList<>();
    public static String onSwitch = null;

    static {
        Map<String, String> yml = YmlInIt.init();
        String[] lists = yml.get("whitelist").split(",");
        String off = yml.get("onswitch");
        onSwitch=off;
        if (lists.length == 0 || StringUtils.isEmpty(lists[0])) {
            throw new Error("未配置白名单！");
        }
        for (String s :
                lists) {
            whiteList.add(s);
        }
    }
}
