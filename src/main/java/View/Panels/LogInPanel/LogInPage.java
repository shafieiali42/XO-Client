package View.Panels.LogInPanel;


import Controller.Controller;
import Util.Constants.Constant;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;


public class LogInPage extends JPanel {

    private JLabel userNameLabel;
    private JLabel passwordLabel;
    private JTextField userNameTextField;
    private JPasswordField passwordField;
    private JButton logInBtn;
    private JButton signUpBtn;
    private JButton exitBtn;


    public LogInPage() {
        setSize(Constant.widthOfMainFrame, Constant.heightOfMainFrame);
        setLayout(null);
        setBackground(Color.GRAY);
        initLabelsAndFields();
        initButtons();
    }


    private void initButtons() {
        initLogInSignUpButton();
        initExitButton();
    }

    private void initExitButton() {
        exitBtn = new JButton("Exit");
        exitBtn.setSize(100, 40);
        exitBtn.setBounds((Constant.widthOfMainFrame - exitBtn.getWidth()) / 2,
                signUpBtn.getY() + 50,
                exitBtn.getWidth(), exitBtn.getHeight());
        exitBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        this.add(exitBtn);
    }

    private void initLogInSignUpButton() {
        signUpBtn = new JButton("SignUp");
        logInBtn = new JButton("LogIn");
        logInBtn.setSize(100, 40);
        signUpBtn.setSize(100, 40);
        signUpBtn.setBounds((Constant.widthOfMainFrame - logInBtn.getWidth() - signUpBtn.getWidth()) / 2 +
                        logInBtn.getWidth() + 5,
                passwordLabel.getY() + 50, logInBtn.getWidth(), logInBtn.getHeight());

        logInBtn.setBounds((Constant.widthOfMainFrame - logInBtn.getWidth() - signUpBtn.getWidth()) / 2,
                passwordLabel.getY() + 50, logInBtn.getWidth(), logInBtn.getHeight());

        signUpBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Controller.getCurrentClient().sendLogInRequest(getUserNameTextField().getText(),
                        new String(getPasswordField().getPassword()),"SignUp");
            }
        });

        logInBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Controller.getCurrentClient().sendLogInRequest(getUserNameTextField().getText(),
                        new String(getPasswordField().getPassword()),"LogIn");
            }
        });

        this.add(logInBtn);
        this.add(signUpBtn);

    }


    private void initLabelsAndFields() {
        userNameLabel = new JLabel("UserName:");
        passwordLabel = new JLabel("Password:");
        passwordLabel.setText("Password:");
        userNameTextField = new JTextField();
        passwordField = new JPasswordField();
        userNameLabel.setSize(65, 20);
        passwordLabel.setSize(60, 20);
        userNameTextField.setSize(80, 20);
        passwordField.setSize(80, 20);
        userNameLabel.setBounds((Constant.widthOfMainFrame - userNameLabel.getWidth() - userNameTextField.getWidth()) / 2,
                350, userNameLabel.getWidth(), userNameLabel.getHeight());
        passwordLabel.setBounds((Constant.widthOfMainFrame - userNameLabel.getWidth() - userNameTextField.getWidth()) / 2,
                400, passwordLabel.getWidth(), passwordLabel.getHeight());

        userNameTextField.setBounds((Constant.widthOfMainFrame - userNameLabel.getWidth() - userNameTextField.getWidth()) / 2 +
                userNameLabel.getWidth() + 5, 350, userNameTextField.getWidth(), userNameTextField.getHeight());

        passwordField.setBounds((Constant.widthOfMainFrame - userNameLabel.getWidth() - userNameTextField.getWidth()) / 2 + passwordLabel.getWidth() + 8,
                400, passwordField.getWidth(), passwordField.getHeight());

        this.add(userNameLabel);
        this.add(userNameTextField);
        this.add(passwordLabel);
        this.add(passwordField);
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        String welcome = "Welcome to XO GAME ";
        g2d.setFont(new Font("TimesRoman", Font.ITALIC, 50));
        Rectangle2D bounds = g.getFontMetrics().getStringBounds(welcome, g2d);
        int lengthOfMessage = (int) bounds.getWidth();
        g2d.drawString(welcome, (Constant.widthOfMainFrame - lengthOfMessage) / 2, 100);
        String message = "Enjoy your time";
        g2d.setFont(new Font("TimesRoman", Font.ITALIC, 30));
        Rectangle2D bounds1 = g.getFontMetrics().getStringBounds(message, g2d);
        int lengthOfMessage1 = (int) bounds1.getWidth();
        g2d.drawString(message, (Constant.widthOfMainFrame - lengthOfMessage1) / 2, 150);
    }


    public JTextField getUserNameTextField() {
        return userNameTextField;
    }

    public JPasswordField getPasswordField() {
        return passwordField;
    }


}

