package Controller;

import Client.Client;
import Main.ClientMain;
import Model.Board.Board;
import Model.Player.Player;
import View.Models.BoardPanel;
import View.Panels.GamePanel.GamePage;
import View.Panels.StatusPanel.StatusPage;

import java.util.ArrayList;

public class Controller {

    private static Client currentClient;


    private static ArrayList<String> userNames=new ArrayList<>();
    private static ArrayList<Boolean> onlineStatus=new ArrayList<>();
    private static ArrayList<Integer> points=new ArrayList<>();
    private static boolean needRepaintScoreBoard;


    public static void showBoard(Board board,String friendlyName,String friendlyIcon,
                                 String enemyName,String enemyIcon,String turn,boolean finished){

        BoardPanel boardPanel=new BoardPanel();
        for (int i = 0; i < board.getBoard().size(); i++) {
            boardPanel.getTilePanels().get(i).setTileStatus(board.getBoard().get(i));
        }
        GamePage gamePage=new GamePage(boardPanel);
        gamePage.setFriendlyName(friendlyName); gamePage.setFriendlyIcon(friendlyIcon);
        gamePage.setEnemyName(enemyName); gamePage.setEnemyIcon(enemyIcon);
        gamePage.setTurn(turn);
        ClientMain.getMyMainFrame().setContentPane(gamePage);
    }


    public static boolean isNeedRepaintScoreBoard() {
        return needRepaintScoreBoard;
    }

    public static void setNeedRepaintScoreBoard(boolean needRepaintScoreBoard) {
        Controller.needRepaintScoreBoard = needRepaintScoreBoard;
    }

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









    //getter and setters
    //********************

    public static Client getCurrentClient() {
        return currentClient;
    }

    public static void setCurrentClient(Client currentClient) {
        Controller.currentClient = currentClient;
    }

}
