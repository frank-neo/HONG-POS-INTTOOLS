import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class testButtonAct implements ActionListener {

    JTextField tokenText;
    JTextField MD5Text;
    JTextField INTurlText;
    JTextField INTparamText;
    JTextArea testResultText;

    testButtonAct(JTextField tokenText, JTextField MD5Text, JTextField INTurlText, JTextField INTparamText, JTextArea testResultText) {
        this.tokenText = tokenText;
        this.MD5Text = MD5Text;
        this.INTurlText = INTurlText;
        this.INTparamText = INTparamText;
        this.testResultText = testResultText;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            String url = INTurlText.getText();
            String token = tokenText.getText();
            String MD5 = MD5Text.getText();
            String param = INTparamText.getText();
            System.out.println("请求接口token：======》" + token);
            System.out.println("请求接口地址：======》" + url + "?" + param);
            String result = HttpClientDemo111.doGet(url + "?" + param+"&sign="+SignMaker.SignMakerDemo(param,MD5), token);
            testResultText.setText(result);
            testResultText.setLineWrap(true);
            testResultText.setWrapStyleWord(true);
        } catch (Exception e1) {
            e1.printStackTrace();
            System.out.println("系统内部错误。");
        }
    }
}
