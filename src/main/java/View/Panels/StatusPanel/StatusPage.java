package View.Panels.StatusPanel;

import Controller.Controller;
import Util.Constants.Constant;
import Util.OtherClasses.LengthOfMessage;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class StatusPage extends JPanel {


    private int width;
    private int height;

    private String userName;
    private int wins;
    private int loose;
    private int points;
    private boolean repaint = false;


    public StatusPage() {
        width = Constant.widthOfMainFrame;
        height = Constant.heightOfMainFrame;
        setSize(width, height);
        setBackground(Color.yellow);
        setLayout(null);
    }


    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D graphics2D = (Graphics2D) g;

        if (repaint) {
            drawStatusPage(userName, wins, loose, points, graphics2D);
        }


    }

    private void drawStatusPage(String userName, int wins, int loose, int points, Graphics2D g2d) {

        g2d.setFont(new Font("TimesRoman", Font.ITALIC, 50));
        g2d.setColor(Color.red);

        int ySpace = Constant.heightOfMainFrame / 5;

        String nameString = "UserName: " + userName;
        int xCoordinate = (Constant.widthOfMainFrame - LengthOfMessage.lengthOfMessage(nameString, g2d)) / 2;
        g2d.drawString(nameString, xCoordinate, ySpace);

        String winsString = "Wins: " + wins;
        xCoordinate = (Constant.widthOfMainFrame - LengthOfMessage.lengthOfMessage(winsString, g2d)) / 2;
        g2d.drawString(winsString, xCoordinate, 2 * ySpace);

        String looseString = "Loose: " + loose;
        xCoordinate = (Constant.widthOfMainFrame - LengthOfMessage.lengthOfMessage(looseString, g2d)) / 2;
        g2d.drawString(looseString, xCoordinate, 3 * ySpace);

        String pointsString = "Points: " + points;
        xCoordinate = (Constant.widthOfMainFrame - LengthOfMessage.lengthOfMessage(pointsString, g2d)) / 2;
        g2d.drawString(pointsString, xCoordinate, 4 * ySpace);


    }


    //getter and setters
    //*********************

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getLoose() {
        return loose;
    }

    public void setLoose(int loose) {
        this.loose = loose;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public boolean isRepaint() {
        return repaint;
    }

    public void setRepaint(boolean repaint) {
        this.repaint = repaint;
    }
}
