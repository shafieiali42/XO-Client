package RequestAndResponse.Response;

import Controller.Controller;
import Main.ClientMain;
import Model.Player.Player;
import View.Panels.ScoreBoard.ScoreBoardPage;
import View.Panels.StatusPanel.StatusPage;

import java.util.ArrayList;

public class StatusResponse extends Response {

    private String userName;
    private int wins;
    private int loose;
    private int score;


    public StatusResponse(String userName,int wins,int loose,int score) {
        this.userName=userName;
        this.wins=wins;
        this.loose=loose;
        this.score=score;
    }




    @Override
    public void execute() {

        if (Controller.getCurrentClient().getPlayer() !=null){
            System.out.println("  " + Controller.getCurrentClient().getPlayer().getUserName());
        }
        Controller.setUserNameInStatus(userName);
        Controller.setWins(wins);
        Controller.setLoose(loose);
        Controller.setScore(score);
        StatusPage statusPage=new StatusPage();
        ClientMain.getMyMainFrame().setContentPane(statusPage);
        statusPage.setRepaint(true);
        statusPage.repaint();
        statusPage.revalidate();

    }



    //getter and setters
    //********************

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

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }


}

