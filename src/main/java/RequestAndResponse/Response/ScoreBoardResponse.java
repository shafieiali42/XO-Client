package RequestAndResponse.Response;

import Controller.Controller;


import View.Panels.ScoreBoard.ScoreBoardPage;

import java.util.ArrayList;

public class ScoreBoardResponse extends Response {


    private ArrayList<String> userNames;
    private ArrayList<Boolean> onlineStatus;
    private ArrayList<Integer> points;


    public ScoreBoardResponse() {

    }




    @Override
    public void execute() {

        if (Controller.getCurrentClient().getPlayer() !=null){
            System.out.println("  " + Controller.getCurrentClient().getPlayer().getUserName());
        }
        Controller.setUserNames(userNames);
        Controller.setOnlineStatus(onlineStatus);
        Controller.setPoints(points);
        Controller.setNeedRepaintScoreBoard(true);

        ScoreBoardPage.getInstance().setRepaint(true);
        ScoreBoardPage.getInstance().repaint();
        ScoreBoardPage.getInstance().revalidate();

    }


    //getter and setters
    //*********************

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





