import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.*;

/**
 * sign签名生成器
 */
public class SignMaker {

    public static String SignMakerDemo(String url, String md5key) {

        String MD5_KEY;
        Map<String, String> requestParam = new HashMap<>();
        List<String> keys = new ArrayList<>();

        try {
            MD5_KEY = md5key.replaceAll("\"", "");
        } catch (Exception e) {
            return "MD5_KEY必须要有参数。";
        }
        try {
            String urls[] = url.split("&");

            for (int i = 0; i < urls.length; i++) {
                if (urls[i].split("=").length == 2) {
                    requestParam.put(urls[i].split("=")[0], urls[i].split("=")[1]);
                    System.out.println("key:" + urls[i].split("=")[0] + "," + "value:" + urls[i].split("=")[1]);
                }
            }
            keys = new ArrayList<String>(requestParam.keySet());
            System.out.println("keys=>{}" + keys);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("参数转化为map，发生错误。");
            return "sign生成失败。";
        }

        keys.remove("sign");// 排除sign参数
        keys.remove("MD5_KEY");//排除MD5_KEY参数
        Collections.sort(keys);// 排序
        StringBuilder sb = new StringBuilder();
        for (String key : keys) {
            sb.append(key).append("=").append(requestParam.get(key)).append("&");// 拼接字符串
        }
        System.out.println("拼接字符串" + sb);
        String linkString = sb.toString();
        linkString = StringUtils.substring(linkString, 0, linkString.length() - 1);// 去除最后一个'&'

        String sign = DigestUtils.md5Hex(linkString + MD5_KEY);// 混合密钥md5
        System.out.println("系统后台生成的sign=============>" + sign);
        return sign;
    }
}
