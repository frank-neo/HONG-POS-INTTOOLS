import javax.swing.*;

public class SwingLoginExample {

    public static void main(String[] args) {
        // 创建 JFrame 实例
        JFrame frame = new JFrame("红pos接口测试工具----shaoxiong.li");
        // Setting the width and height of frame
        frame.setSize(700, 830);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /* 创建面板，这个类似于 HTML 的 div 标签
         * 我们可以创建多个面板并在 JFrame 中指定位置
         * 面板中我们可以添加文本字段，按钮及其他组件。
         */
        JPanel panel = new JPanel();
        // 添加面板
        frame.add(panel);
        /*
         * 调用用户定义的方法并添加组件到面板
         */
        placeComponents(panel);

        // 设置界面可见
        frame.setVisible(true);
    }

    private static void placeComponents(JPanel panel) {

        /* 布局部分我们这边不多做介绍
         * 这边设置布局为 null
         */
        panel.setLayout(null);

        //接口说面性文档
        JLabel toolInf = new JLabel("目前此接口只能测试红pos的请求接口。");
        toolInf.setBounds(10,0,300,25);
        panel.add(toolInf);

        //登录标题
        JLabel loginInf = new JLabel("-------------------------------------------------------------------------测试接口前必须先登录------------------------------------------------------------------");
        loginInf.setBounds(0,20,700,25);
        panel.add(loginInf);


        JLabel userLabel = new JLabel("账号:");
        userLabel.setBounds(10,50,50,25);
        panel.add(userLabel);

        //登录账户
        JTextField userText = new JTextField(20);
        userText.setBounds(100,50,550,25);
        panel.add(userText);

        //登录密码
        JLabel passwordLabel = new JLabel("密码:");
        passwordLabel.setBounds(10,80,50,25);
        panel.add(passwordLabel);


        JTextField passwordText = new JTextField(20);
        passwordText.setBounds(100,80,550,25);
        panel.add(passwordText);

        //登录结果
        JLabel loginResult = new JLabel("登录结果：");
        loginResult.setBounds(10,110,160,25);
        panel.add(loginResult);


        JTextArea loginResultText = new JTextArea();
        //loginResultText.setBounds(100,110,550,150);
        //自动换行
        //loginResultText.setLineWrap(true);
        //文字不打断
        //loginResultText.setWrapStyleWord(true);
        //panel.add(loginResultText);
        //滚动条
        JScrollPane loginRoll = new JScrollPane(loginResultText);
        loginRoll.setBounds(100, 110, 550, 150);
        panel.add(loginRoll);


        //分割线
        JLabel FGX = new JLabel("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        FGX.setBounds(0,250,700,25);
        panel.add(FGX);

        //接口测试区域
        //token
        JLabel token = new JLabel("token:");
        token.setBounds(10,280,50,25);
        panel.add(token);

        JTextField tokenText = new JTextField(20);
        tokenText.setBounds(100,280,550,25);
        panel.add(tokenText);

        //MD5-KEY
        JLabel md5Label = new JLabel("MD5-KEY:");
        md5Label.setBounds(10,310,50,25);
        panel.add(md5Label);

        JTextField MD5Text = new JTextField(20);
        MD5Text.setBounds(100,310,550,25);
        panel.add(MD5Text);

        //SIGN
        JLabel signLabel = new JLabel("SIGN:");
        signLabel.setBounds(10,340,50,25);
        panel.add(signLabel);

        JTextField signText = new JTextField(20);
        signText.setBounds(100,340,550,25);
        panel.add(signText);

        //接口
        JLabel INTurl = new JLabel("接口地址:");
        INTurl.setBounds(10,370,80,25);
        panel.add(INTurl);

        JTextField INTurlText = new JTextField(20);
        INTurlText.setBounds(100,370,550,25);
        panel.add(INTurlText);

        //接口参数
        JLabel INTparam = new JLabel("参数字符串：");
        INTparam.setBounds(10,400,110,25);
        panel.add(INTparam);

        JTextField INTparamText = new JTextField(20);
        INTparamText.setBounds(100,400,550,25);
        panel.add(INTparamText);


        //测试结果
        JLabel testResult = new JLabel("测试结果：");
        testResult.setBounds(10,430,160,25);
        panel.add(testResult);


        JTextArea testResultText = new JTextArea();
        JScrollPane testResultRoll = new JScrollPane(testResultText);
        testResultRoll.setBounds(100,430,550,280);
        panel.add(testResultRoll);
        //testResultText.setLineWrap(true);
        //testResultText.setWrapStyleWord(true);
        //testResultText.setBounds(100,400,550,280);
        //panel.add(testResultText);


        //创建登录按钮
        JButton loginButton = new JButton("登录");
        loginButton.setBounds(10, 230, 80, 25);
        LoginButoAct loginButoAct = new LoginButoAct(userText,passwordText,loginResultText,tokenText,MD5Text,signText);
        loginButton.addActionListener(loginButoAct);
        panel.add(loginButton);

        // 创建测试按钮
        JButton testButton = new JButton("测试");
        testButton.setBounds(10, 680, 80, 25);
        testButtonAct testButtonAct =new testButtonAct(tokenText,MD5Text,INTurlText,INTparamText,testResultText,signText);
        testButton.addActionListener(testButtonAct);
        panel.add(testButton);

        //lee
        JLabel editor = new JLabel("version 1.10");
        editor.setBounds(610,740,100,25);
        JLabel editor1 = new JLabel("by shaoxiong.li_c");
        editor1.setBounds(580,760,100,25);
        panel.add(editor);
        panel.add(editor1);
    }
}