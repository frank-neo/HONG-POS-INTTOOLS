package com.test.signtest;

import org.apache.commons.lang3.StringUtils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.*;

/**
 * 请求参数解析小工具。
 */
public class ParamUnit {

    public static String paramUTF8(String url, String type) {

        Map<String, String> requestParam = new HashMap<>();
        List<String> keys;

        String urls[] = url.split("&");

        for (int i = 0; i < urls.length; i++) {
            if (urls[i].split("=").length == 2) {
                String key = urls[i].split("=")[0];
                String value = urls[i].split("=")[1];

                if ("nomal".equals(type)) {
                    requestParam.put(key, value);
                } else {
                    try {
                        key = URLEncoder.encode(key, "UTF-8");
                        value = URLEncoder.encode(value, "UTF-8");
                        requestParam.put(key, value);
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                        System.out.println("请求参数转码失败。");
                        return null;
                    }
                }
            }
        }

        keys = new ArrayList<String>(requestParam.keySet());

        keys.remove("sign");// 排除sign参数
        keys.remove("MD5_KEY");//排除MD5_KEY参数
        Collections.sort(keys);// 排序

        StringBuilder sb = new StringBuilder();
        for (String key : keys) {
            sb.append(key).append("=").append(requestParam.get(key)).append("&");// 拼接字符串
        }
        String linkString = sb.toString();
        linkString = StringUtils.substring(linkString, 0, linkString.length() - 1);// 去除最后一个'&'
        return linkString;
    }
}
