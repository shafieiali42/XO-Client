package View.Panels.ScoreBoard;

import Util.Constants.Constant;
import Util.OtherClasses.LengthOfMessage;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ScoreBoardPage extends JPanel {


    private int width;
    private int height;
    private JScrollPane jScrollPane;
    private boolean repaint;

    private ArrayList<String> userNames;
    private ArrayList<Boolean> onlineStatus;
    private ArrayList<Integer> points;

    public ScoreBoardPage() {
        width = Constant.widthOfMainFrame;
        height = 5 * Constant.heightOfMainFrame;
        setSize(width, height);
        setJScrollPane(new JScrollPane(this));
        setLayout(null);
        userNames = new ArrayList<>();
        onlineStatus = new ArrayList<>();
        points = new ArrayList<>();

    }


    @Override
    protected void paintComponent(Graphics g) {

        Graphics2D graphics2D = (Graphics2D) g;

        drawScoreBoardPage(userNames, onlineStatus, points, graphics2D);

    }

    private void drawScoreBoardPage(ArrayList<String> names, ArrayList<Boolean> onlineStatus,
                                    ArrayList<Integer> points, Graphics2D g2d) {


        g2d.setFont(new Font("TimesRoman", Font.ITALIC, 50));
        g2d.setColor(Color.red);

        int ySpace = Constant.heightOfMainFrame / (names.size()+1);
        String xSpace = "";
        for (int i = 0; i < Constant.widthOfMainFrame / 4; i++) {
            xSpace = xSpace + " ";
        }
        for (int i = 0; i < names.size(); i++) {
            String playerState = names.get(i) + xSpace + onlineStatus.get(i) + xSpace + points.get(i);
            int xCoordinate = (Constant.widthOfMainFrame - LengthOfMessage.lengthOfMessage(playerState, g2d)) / 2;
            g2d.drawString(playerState, xCoordinate, (i + 1) * ySpace);
        }
    }


    //getter and setters
    //********************

    public JScrollPane getJScrollPane() {
        return jScrollPane;
    }

    public void setJScrollPane(JScrollPane jScrollPane) {
        this.jScrollPane = jScrollPane;
    }

    public boolean isRepaint() {
        return repaint;
    }

    public void setRepaint(boolean repaint) {
        this.repaint = repaint;
    }

    public ArrayList<String> getUserNames() {
        return userNames;
    }

    public void setUserNames(ArrayList<String> userNames) {
        this.userNames = userNames;
    }

    public ArrayList<Boolean> getOnlineStatus() {
        return onlineStatus;
    }

    public void setOnlineStatus(ArrayList<Boolean> onlineStatus) {
        this.onlineStatus = onlineStatus;
    }

    public ArrayList<Integer> getPoints() {
        return points;
    }

    public void setPoints(ArrayList<Integer> points) {
        this.points = points;
    }


}
