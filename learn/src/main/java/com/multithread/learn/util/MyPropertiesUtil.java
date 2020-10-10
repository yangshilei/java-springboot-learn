package com.multithread.learn.util;

import lombok.extern.slf4j.Slf4j;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

/**
 * properties.properties文件读取工具类
 */
@Slf4j
public class MyPropertiesUtil {

    public static String getValue(String key){
        Properties properties = new Properties();
        try {
            properties.load(new InputStreamReader(org.apache.logging.log4j.util.PropertiesUtil.class.getClassLoader().getResourceAsStream("properties.properties"),"UTF-8"));
        } catch (IOException e) {
            e.printStackTrace();
            log.error("properties.properties配置文件读取失败");
        }

        return properties.getProperty(key);
    }

}
