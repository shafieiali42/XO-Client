package View.Panels.GamePanel;


import Client.Client;
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
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class GamePage extends JPanel {

    private BoardPanel boardPanel;
    private String turn;
    private String friendlyName;
    private String friendlyIcon;
    private String enemyName;
    private String enemyIcon;
    private boolean showWinner=false;
    private String winner;
    private JButton backBtn;
    private Color colorOfTextOfBtn = new Color(255, 0, 0);
    private Color colorOfBtn = new Color(48, 48, 45);

    public GamePage(BoardPanel boardPanel) {
        setSize(Constant.widthOfMainFrame, Constant.heightOfMainFrame);
        setLayout(null);
        setBackground(Color.gray);
        this.boardPanel = boardPanel;
        this.addPanel(boardPanel, 0, 0, Constant.boardWidth, Constant.boardHeight);
        initBackBtn();
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
        backBtn.setBounds(50,Constant.boardHeight+100,backBtn.getWidth(),backBtn.getHeight());
        backBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ClientMain.getMyMainFrame().setContentPane(new MainMenuPage());
                Controller.getCurrentClient().sendEndGameRequest();
            }
        });
        add(backBtn);
    }




    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D graphics2D = (Graphics2D) g;
        showInfo(friendlyName, friendlyIcon, enemyName, enemyIcon, turn, graphics2D);
        if (showWinner){
            graphics2D.setFont(new Font("TimesRoman", Font.ITALIC, 50));
            int length=LengthOfMessage.lengthOfMessage(winner,graphics2D);
            graphics2D.drawString(winner,(Constant.widthOfMainFrame-length)/2,Constant.heightOfMainFrame-100);
        }
    }

    private void showInfo(String friendlyName, String friendlyIcon, String enemyName, String enemyIcon, String turn, Graphics2D g2d) {

        g2d.setFont(new Font("TimesRoman", Font.ITALIC, 30));
        int length = LengthOfMessage.lengthOfMessage(friendlyName + "  " + friendlyIcon, g2d);
        int xCoordinate = Constant.boardWidth+(Constant.widthOfMainFrame - Constant.boardWidth- length) / 2;
        int yCoordinate = 150;
        g2d.drawString(friendlyName + "  " + friendlyIcon, xCoordinate, yCoordinate);

        length = LengthOfMessage.lengthOfMessage(enemyName + "  " + enemyIcon, g2d);
        xCoordinate = Constant.boardWidth+(Constant.widthOfMainFrame - Constant.boardWidth- length) / 2;
        yCoordinate = Constant.heightOfMainFrame - 150;
        g2d.drawString(enemyName + "  " + enemyIcon, xCoordinate, yCoordinate);

        length = LengthOfMessage.lengthOfMessage("Turn: "+turn, g2d);
        xCoordinate = Constant.boardWidth+(Constant.widthOfMainFrame -Constant.boardWidth- length) / 2;
        yCoordinate = Constant.heightOfMainFrame/2;
        g2d.drawString("Turn: "+turn, xCoordinate, yCoordinate);

    }


    public void addPanel(JPanel panel, int x, int y, int width, int height) {
        panel.setBounds(x, y, width, height);
        add(panel);
    }



    //getter and setters
    //********************

    public BoardPanel getBoardPanel() {
        return boardPanel;
    }

    public void setBoardPanel(BoardPanel boardPanel) {
        this.boardPanel = boardPanel;
    }

    public String getTurn() {
        return turn;
    }

    public void setTurn(String turn) {
        this.turn = turn;
    }

    public String getFriendlyName() {
        return friendlyName;
    }

    public void setFriendlyName(String friendlyName) {
        this.friendlyName = friendlyName;
    }

    public String getFriendlyIcon() {
        return friendlyIcon;
    }

    public void setFriendlyIcon(String friendlyIcon) {
        this.friendlyIcon = friendlyIcon;
    }

    public String getEnemyName() {
        return enemyName;
    }

    public void setEnemyName(String enemyName) {
        this.enemyName = enemyName;
    }

    public String getEnemyIcon() {
        return enemyIcon;
    }

    public void setEnemyIcon(String enemyIcon) {
        this.enemyIcon = enemyIcon;
    }

    public boolean isShowWinner() {
        return showWinner;
    }

    public void setShowWinner(boolean showWinner) {
        this.showWinner = showWinner;
    }

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }

}
