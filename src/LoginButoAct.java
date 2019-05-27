import com.alibaba.fastjson.JSON;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

public class LoginButoAct implements ActionListener {

    JTextField userText;
    JTextField passwordText;
    JTextArea loginResultText;
    JTextField tokenText;
    JTextField MD5Text;
    JTextField signText;

    public LoginButoAct(JTextField userText, JTextField passwordText, JTextArea loginResultText, JTextField tokenText, JTextField MD5Text,JTextField signText) {
        this.userText = userText;
        this.passwordText = passwordText;
        this.loginResultText = loginResultText;
        this.tokenText = tokenText;
        this.MD5Text = MD5Text;
        this.signText = signText;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //把地址和账户密码+MD5-KEY拼接成字符串然后请求地址
        try {
            System.out.println(userText.getText() + passwordText.getText());
            String param = "USR_LOGIN=" + userText.getText() + "&" + "USR_LOGIN_PWD=" + passwordText.getText();
            String sign = SignMaker.SignMakerDemo(param, "MD5_KEY");
            String url = "http://192.168.25.116:8480/appagt/appagt/usr/login" + "?" + param
                    + "&sign=" + sign;
            System.out.println("请求地址为：" + url);
            String result = HttpClientDemo111.doGet(url, null);

            //尝试获取md5和token
            WebBaseResponse response = JSON.parseObject(result,WebBaseResponse.class);
            loginResultText.setText(JsonBeauty.JsonFomart(response));

            signText.setText(sign);
            System.out.println("sign=========>"+response.getRspMap().get("sign"));
            tokenText.setText((String) response.getRspMap().get("token"));
            System.out.println("token=========>"+response.getRspMap().get("token"));
            MD5Text.setText((String) response.getRspMap().get("MD5_KEY"));
            System.out.println("MD5_KEY=========>"+response.getRspMap().get("MD5_KEY"));
        } catch (Exception e1) {
            e1.printStackTrace();
            loginResultText.setText("工具内部出错。json格式转换错误。");
        }
    }
}
