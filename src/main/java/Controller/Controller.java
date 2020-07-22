package Controller;

import Client.Client;
import Model.Player.Player;
import View.Panels.StatusPanel.StatusPage;

public class Controller {

    private static Client currentClient;


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
