import com.alibaba.fastjson.JSON;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

public class testButtonAct implements ActionListener {

    JTextField tokenText;
    JTextField MD5Text;
    JTextField INTurlText;
    JTextField INTparamText;
    JTextArea testResultText;
    JTextField signText;

    testButtonAct(JTextField tokenText, JTextField MD5Text, JTextField INTurlText, JTextField INTparamText, JTextArea testResultText,JTextField signText) {
        this.tokenText = tokenText;
        this.MD5Text = MD5Text;
        this.INTurlText = INTurlText;
        this.INTparamText = INTparamText;
        this.testResultText = testResultText;
        this.signText = signText;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            String url = INTurlText.getText();
            String token = tokenText.getText();
            String MD5 = MD5Text.getText();
            String param = INTparamText.getText();
            String sign = SignMaker.SignMakerDemo(param, MD5);

            System.out.println("请求接口token：======》" + token);
            String getUrl = url + "?" + ParamUnit.paramUTF8(param,"utfParam") + "&sign=" + sign;

            String result = HttpClientDemo111.doGet(getUrl, token);

            WebBaseResponse response = JSON.parseObject(result, WebBaseResponse.class);
            testResultText.setText(JsonBeauty.JsonFomart(response));
            signText.setText(sign);
            //System.out.println("testResultText文本结构数据：===》" + result);
        } catch (Exception e1) {
            e1.printStackTrace();
            System.out.println("系统内部错误。");
            testResultText.setText("系统内部错误。");
        }
    }
}
