package View.Panels.GamePanel;


import Util.Constants.Constant;
import Util.OtherClasses.LengthOfMessage;
import View.Models.BoardPanel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class GamePage extends JPanel {

    private BoardPanel boardPanel;
    private String turn;
    private String friendlyName;
    private String friendlyIcon;
    private String enemyName;
    private String enemyIcon;


    public GamePage(BoardPanel boardPanel) {
        setSize(Constant.widthOfMainFrame, Constant.heightOfMainFrame);
        setLayout(null);
        this.boardPanel = boardPanel;
        this.addPanel(boardPanel, 0, 0, Constant.boardWidth, Constant.boardHeight);
    }


    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D graphics2D = (Graphics2D) g;
        showInfo(friendlyName, friendlyIcon, enemyName, enemyIcon, turn, graphics2D);
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


}
