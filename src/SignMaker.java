import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.*;

/**
 * sign签名生成器
 */
public class SignMaker {

    public static String SignMakerDemo(String url, String md5key) {

        String MD5_KEY;
        try {
            MD5_KEY = md5key.replaceAll("\"", "");
        } catch (Exception e) {
            return "MD5_KEY必须要有参数。";
        }
        String newurl = ParamUnit.paramUTF8(url,"nomal");
        System.out.println("SignMaker排序后的参数字符串：" + newurl);
        String sign = DigestUtils.md5Hex(newurl + MD5_KEY);// 混合密钥md5
        System.out.println("系统后台生成的sign=============>" + sign);
        return sign;
    }
}
