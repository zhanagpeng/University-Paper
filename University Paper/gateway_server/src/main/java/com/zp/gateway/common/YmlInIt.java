package com.zp.gateway.common;

import org.springframework.context.annotation.Profile;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @author zp
 * @create 2021/7/20 15:24
 * @desc  配置文件初始化
 **/
public class YmlInIt {
    public static final String FILE_NAME = "application.yml";

    public static Map<String, String> init() {
        InputStream in = Profile.class.getClassLoader().getResourceAsStream(FILE_NAME);

        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        Properties props = new Properties();
        Map<String, String> profileMap = new HashMap<String, String>();
        try {
            props.load(reader);
            for (Object key : props.keySet()) {
                profileMap.put(key.toString(), props.getProperty(key.toString()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return profileMap;
        }
    }


}
