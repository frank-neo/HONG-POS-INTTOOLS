import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * json美化输出工具
 */
public class JsonBeauty {

    public static String JsonFomart(Object result) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        //格式化/美化/优雅的输出
        //System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(result));
        return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(result);
    }

    //String自动换行。
    public static String autoHuanhang(String result){
        StringBuffer sbf = new StringBuffer();
        sbf.append(result);
        for (int i = sbf.length() -100; i >0; i-=100) {
            sbf.insert(i,"\\n");
        }
        return result;
    }
}
