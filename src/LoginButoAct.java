import com.alibaba.fastjson.JSON;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

public class LoginButoAct implements ActionListener {

    JTextField userText;
    JTextField passwordText;
    JTextField loginResultText;

    public LoginButoAct(JTextField userText, JTextField passwordText, JTextField loginResultText) {
        this.userText = userText;
        this.passwordText = passwordText;
        this.loginResultText = loginResultText;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //把地址和账户密码+MD5-KEY拼接成字符串然后请求地址
        try {
            System.out.println(userText.getText() + passwordText.getText());
            String result = HttpClientDemo111.doGet("http://localhost:8080/romeo/WebStatus");

            Map map = (Map) JSON.parse(result);
            System.out.println(map.get("status"));
            loginResultText.setText(result);
        } catch (Exception e1) {
            e1.printStackTrace();
            loginResultText.setText("工具内部出错。json格式转换错误。");
        }
    }
}
