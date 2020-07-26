package View.Panels.StatusPanel;

import Controller.Controller;
import Main.ClientMain;
import Util.Constants.Constant;
import Util.OtherClasses.LengthOfMessage;
import View.Panels.MainMenu.MainMenuPage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class StatusPage extends JPanel {


    private int width;
    private int height;


    private boolean repaint = false;
    private JButton backBtn;
    private Color colorOfTextOfBtn = new Color(255, 0, 0);
    private Color colorOfBtn = new Color(48, 48, 45);


    public StatusPage() {
        width = Constant.widthOfMainFrame;
        height = Constant.heightOfMainFrame;
        setSize(width, height);
        setBackground(Color.yellow);
        initBackBtn();
        setLayout(null);
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

        if (repaint) {
            drawStatusPage(Controller.getUserNameInStatus(), Controller.getWins(), Controller.getLoose(),
                    Controller.getScore(), graphics2D);
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


    public boolean isRepaint() {
        return repaint;
    }

    public void setRepaint(boolean repaint) {
        this.repaint = repaint;
    }
}
