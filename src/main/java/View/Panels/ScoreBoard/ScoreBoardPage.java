package View.Panels.ScoreBoard;

import Controller.Controller;
import Util.Constants.Constant;
import Util.OtherClasses.LengthOfMessage;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ScoreBoardPage extends JPanel {


    private int width;
    private int height;
    private JScrollPane jScrollPane;
    private volatile boolean repaint;


    private static ScoreBoardPage scoreBoardPage = new ScoreBoardPage();

    public static ScoreBoardPage getInstance() {
        return scoreBoardPage;
    }

    public ScoreBoardPage() {

        width = Constant.widthOfMainFrame;
        height = 5 * Constant.heightOfMainFrame;
        setSize(width, height);
//        setJScrollPane(new JScrollPane(this));
        setLayout(null);

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D graphics2D = (Graphics2D) g;
        Controller.getCurrentClient().sendShowScoreBoardRequest();
        drawScoreBoardPage(Controller.getUserNames(), Controller.getOnlineStatus(), Controller.getPoints(), graphics2D);
    }


    private void drawScoreBoardPage(ArrayList<String> names, ArrayList<Boolean> onlineStatus,
                                    ArrayList<Integer> points, Graphics2D g2d) {


        g2d.setFont(new Font("TimesRoman", Font.ITALIC, 10));
        g2d.setColor(Color.red);

        int ySpace = Constant.heightOfMainFrame / (names.size() + 1);
        String xSpace = "";
        for (int i = 0; i < 20; i++) {
            xSpace = xSpace + " ";
        }

        System.out.println(names.size());
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
        System.out.println(repaint + " " + this.repaint);
    }




}
