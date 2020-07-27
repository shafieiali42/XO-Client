package Controller;

import Client.Client;
import Main.ClientMain;
import Model.Board.Board;
import Model.Player.Player;
import View.Models.BoardPanel;
import View.Panels.GamePanel.GamePage;
import View.Panels.StatusPanel.StatusPage;
import View.Panels.screenRecorderPage.ScreenRecorderPage;

import javax.swing.*;
import java.util.ArrayList;

public class Controller {

    private static Client currentClient;


    private static ArrayList<String> userNames = new ArrayList<>();
    private static ArrayList<Boolean> onlineStatus = new ArrayList<>();
    private static ArrayList<Integer> points = new ArrayList<>();
    private static boolean needRepaintScoreBoard;

    private static String userNameInStatus;
    private static int wins;
    private static int loose;
    private static int score;

    private static ArrayList<Board> boards;

    public static void showBoard(Board board, String friendlyName, String friendlyIcon,
                                 String enemyName, String enemyIcon, String turn, String resultList) {

        BoardPanel boardPanel = new BoardPanel();
        for (int i = 0; i < board.getBoard().size(); i++) {
            boardPanel.getTilePanels().get(i).setTileStatus(board.getBoard().get(i));
        }
        GamePage gamePage = new GamePage(boardPanel);
        gamePage.setFriendlyName(friendlyName);
        gamePage.setFriendlyIcon(friendlyIcon);
        gamePage.setEnemyName(enemyName);
        gamePage.setEnemyIcon(enemyIcon);
        gamePage.setTurn(turn);
        ClientMain.getMyMainFrame().setContentPane(gamePage);

        if (!resultList.equalsIgnoreCase("null")) {
            gamePage.setWinner(resultList);
            gamePage.setShowWinner(true);
        }
    }


    public static void showScreenBoard(int index) {

        System.out.println(boards);
        if (index < 0) {
            JOptionPane.showMessageDialog(null, "its the first page",
                    "Error", JOptionPane.ERROR_MESSAGE);
        } else if (index >= boards.size()) {
            JOptionPane.showMessageDialog(null, "its the last page",
                    "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            BoardPanel boardPanel = new BoardPanel();
            for (int i = 0; i < boards.get(index).getBoard().size(); i++) {
                boardPanel.getTilePanels().get(i).setTileStatus(boards.get(index).getBoard().get(i));
            }
            ScreenRecorderPage screenRecorderPage = new ScreenRecorderPage(boardPanel);
            screenRecorderPage.setBoardIndex(index);
            ClientMain.getMyMainFrame().setContentPane(screenRecorderPage);
        }

    }


//    public static void showStatus(Player player, StatusPage statusPage){
//        statusPage.setUserName(player.getUserName());
//        statusPage.setWins(player.getWins());
//        statusPage.setLoose(player.getLoose());
//        statusPage.setPoints(player.getScore());
//        statusPage.setRepaint(true);
//        statusPage.repaint();
//        statusPage.revalidate();
//    }


    //getter and setters
    //********************

    public static Client getCurrentClient() {
        return currentClient;
    }

    public static void setCurrentClient(Client currentClient) {
        Controller.currentClient = currentClient;
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

    public static String getUserNameInStatus() {
        return userNameInStatus;
    }

    public static void setUserNameInStatus(String userNameInStatus) {
        Controller.userNameInStatus = userNameInStatus;
    }

    public static int getWins() {
        return wins;
    }

    public static void setWins(int wins) {
        Controller.wins = wins;
    }

    public static int getLoose() {
        return loose;
    }

    public static void setLoose(int loose) {
        Controller.loose = loose;
    }

    public static int getScore() {
        return score;
    }

    public static void setScore(int score) {
        Controller.score = score;
    }

    public static ArrayList<Board> getBoards() {
        return boards;
    }

    public static void setBoards(ArrayList<Board> boards) {
        Controller.boards = boards;
    }

}
