package Controller;

import Client.Client;
import Model.Player.Player;
import View.Panels.StatusPanel.StatusPage;

import java.util.ArrayList;

public class Controller {

    private static Client currentClient;


    private static ArrayList<String> userNames=new ArrayList<>();
    private static ArrayList<Boolean> onlineStatus=new ArrayList<>();
    private static ArrayList<Integer> points=new ArrayList<>();




    public static ArrayList<String> getUserNames() {
        return userNames;
    }

    public static void setUserNames(ArrayList<String> userNames) {
        Controller.userNames = userNames;
    }

    public static ArrayList<Boolean> getOnlineStatus() {
        return onlineStatus;
    }

    public static void setOnlineStatus(ArrayList<Boolean> onlineStatus) {
        Controller.onlineStatus = onlineStatus;
    }

    public static ArrayList<Integer> getPoints() {
        return points;
    }

    public static void setPoints(ArrayList<Integer> points) {
        Controller.points = points;
    }

    public static void showStatus(Player player, StatusPage statusPage){
        statusPage.setUserName(player.getUserName());
        statusPage.setWins(player.getWins());
        statusPage.setLoose(player.getLoose());
        statusPage.setPoints(player.getScore());
        statusPage.setRepaint(true);
        statusPage.repaint();
        statusPage.revalidate();
    }


    public static void showScoreBoard(){






    }






    //getter and setters
    //********************

    public static Client getCurrentClient() {
        return currentClient;
    }

    public static void setCurrentClient(Client currentClient) {
        Controller.currentClient = currentClient;
    }

}
