package View.Panels.MainMenu;

import Controller.Controller;
import Main.ClientMain;
import Util.Constants.Constant;
import View.Models.BoardPanel;
import View.Panels.GamePanel.GamePage;
import View.Panels.ScoreBoard.ScoreBoardPage;
import View.Panels.StatusPanel.StatusPage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class MainMenuPage extends JPanel {


    private JPanel menuPanel;

    private JButton multiPlayer;
    private JButton scoreBoardBtn;
    private JButton statusBtn;
    private JButton screenRecordBtn;
    private JButton exitBtn;

    private int width;
    private int height;


    private Color colorOfBtn = new Color(48, 48, 45);
    private Color colorOfTextOfBtn = new Color(255, 0, 0);



    public MainMenuPage() {
        width = Constant.widthOfMainFrame;
        height = Constant.heightOfMainFrame;
        setSize(width, height);
        setLayout(null);
        initButtons();
        add(menuPanel);
    }


    private void initButtons() {
        initMenuPanel();
        initMultiPlayerBtn();
        initScoreBoardBtn();
        initStatusBtn();
        initScreenRecordBtn();
        initExitBtn();
    }


    private void initScreenRecordBtn() {
        screenRecordBtn = new JButton("ScreenRecord");
        screenRecordBtn.setFont(new Font("TimesRoman", Font.ITALIC, 30));
        screenRecordBtn.setForeground(colorOfTextOfBtn);
        screenRecordBtn.setBackground(colorOfBtn);
        screenRecordBtn.setSize(this.getWidth(), this.getHeight() / 5);
        screenRecordBtn.setBounds(0, menuPanel.getHeight() * 3 / 5, screenRecordBtn.getWidth(), screenRecordBtn.getHeight());
        screenRecordBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Controller.getCurrentClient().sendScreenRecorderRequest();
            }
        });
        menuPanel.add(screenRecordBtn);

    }

    public void initExitBtn() {
        exitBtn = new JButton("Exit");
        exitBtn.setFont(new Font("TimesRoman", Font.ITALIC, 30));
        exitBtn.setForeground(colorOfTextOfBtn);
        exitBtn.setBackground(colorOfBtn);
        exitBtn.setSize(this.getWidth(), this.getHeight() / 5);
        exitBtn.setBounds(0, menuPanel.getHeight() * 4 / 5, exitBtn.getWidth(), exitBtn.getHeight() - 30);
        exitBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Controller.getCurrentClient().sendLogOutRequest();
                System.exit(0);
            }
        });
        menuPanel.add(exitBtn);
    }

    private void initStatusBtn() {
        statusBtn = new JButton("Status");
        statusBtn.setFont(new Font("TimesRoman", Font.ITALIC, 30));
        statusBtn.setForeground(colorOfTextOfBtn);
        statusBtn.setBackground(colorOfBtn);
        statusBtn.setSize(this.getWidth(), this.getHeight() / 5);
        statusBtn.setBounds(0, menuPanel.getHeight() * 2 / 5, statusBtn.getWidth(), statusBtn.getHeight());
        statusBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Controller.getCurrentClient().sendStatusRequest();

            }
        });
        menuPanel.add(statusBtn);

    }


    private void initScoreBoardBtn() {
        scoreBoardBtn = new JButton("ScoreBoard");
        scoreBoardBtn.setFont(new Font("TimesRoman", Font.ITALIC, 30));
        scoreBoardBtn.setForeground(Color.RED);
        scoreBoardBtn.setBackground(colorOfBtn);
        scoreBoardBtn.setSize(this.getWidth(), this.getHeight() / 5);
        scoreBoardBtn.setBounds(0, menuPanel.getHeight() / 5, scoreBoardBtn.getWidth(), scoreBoardBtn.getHeight());
        scoreBoardBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Controller.getCurrentClient().sendShowScoreBoardRequest();
                ScoreBoardPage scoreBoardPage=new ScoreBoardPage();
                ClientMain.getMyMainFrame().setContentPane(scoreBoardPage);
            }
        });
        menuPanel.add(scoreBoardBtn);
    }

    private void initMultiPlayerBtn() {
        multiPlayer = new JButton("Play");
        multiPlayer.setFont(new Font("TimesRoman", Font.ITALIC, 30));
        multiPlayer.setForeground(Color.RED);
        multiPlayer.setBackground(colorOfBtn);
        multiPlayer.setSize(this.getWidth(), this.getHeight() / 5);
        multiPlayer.setBounds(0, 0, multiPlayer.getWidth(), multiPlayer.getHeight());
        multiPlayer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Controller.getCurrentClient().sendPlayRequest();
            }
        });
        menuPanel.add(multiPlayer);

    }


    private void initMenuPanel() {
        menuPanel = new JPanel();
        menuPanel.setLayout(null);
        menuPanel.setSize(new Dimension(this.getWidth(), this.getHeight()));
        menuPanel.setBounds(0, 0, menuPanel.getWidth(), menuPanel.getHeight());
        menuPanel.setBackground(colorOfBtn);
    }


}
