package View.Panels.screenRecorderPage;

import Controller.Controller;
import Main.ClientMain;
import Util.Constants.Constant;
import Util.OtherClasses.LengthOfMessage;
import View.Models.BoardPanel;
import View.Panels.MainMenu.MainMenuPage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ScreenRecorderPage extends JPanel {


    private BoardPanel boardPanel;
    private int boardIndex;
    private JButton nextBoardBtn;
    private JButton previousBoardBan;
    private JButton backBtn;
    private Color colorOfTextOfBtn = new Color(255, 0, 0);
    private Color colorOfBtn = new Color(48, 48, 45);

    public ScreenRecorderPage(BoardPanel boardPanel) {
        setSize(Constant.widthOfMainFrame, Constant.heightOfMainFrame);
        setLayout(null);
        this.boardPanel = boardPanel;
        this.addPanel(boardPanel, 0, 0, Constant.boardWidth, Constant.boardHeight);
        initBackBtn();
        initNextBoardBtn();
        initPreviousBoardBtn();
    }

    private void initPreviousBoardBtn() {
        previousBoardBan = new JButton("Previous");
        designBtn(previousBoardBan);
        previousBoardBan.setBounds(320, Constant.boardHeight + 100,
                previousBoardBan.getWidth(), previousBoardBan.getHeight());
        previousBoardBan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Controller.showScreenBoard(boardIndex-1);
            }
        });
        add(previousBoardBan);
    }

    private void initNextBoardBtn() {
        nextBoardBtn = new JButton("Next");
        designBtn(nextBoardBtn);
        nextBoardBtn.setBounds(230, Constant.boardHeight + 100, nextBoardBtn.getWidth(), nextBoardBtn.getHeight());
        nextBoardBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("index: "+(boardIndex+1));
                    Controller.showScreenBoard(boardIndex+1);
            }
        });
        add(nextBoardBtn);
    }


    public void designBtn(JButton btn) {
        btn.setSize(90, 90);
        btn.setFont(new Font("TimesRoman", Font.ITALIC, 20));
        btn.setForeground(colorOfTextOfBtn);
        btn.setBackground(colorOfBtn);
    }

    private void initBackBtn() {
        backBtn = new JButton("Back");
        designBtn(backBtn);
        backBtn.setBounds(50, Constant.boardHeight + 100, backBtn.getWidth(), backBtn.getHeight());
        backBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ClientMain.getMyMainFrame().setContentPane(new MainMenuPage());
            }
        });
        add(backBtn);
    }


    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D graphics2D = (Graphics2D) g;


    }



    public void addPanel(JPanel panel, int x, int y, int width, int height) {
        panel.setBounds(x, y, width, height);
        add(panel);
    }


    //getter and setters
    //********************

    public int getBoardIndex() {
        return boardIndex;
    }

    public void setBoardIndex(int boardIndex) {
        this.boardIndex = boardIndex;
    }
}
