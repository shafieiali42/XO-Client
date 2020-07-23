package Main;

import Client.Client;
import Controller.Controller;
import View.Loop.GraphicLoop;
import View.Panels.LogInPanel.LogInPage;
import View.Panels.MyMainFrame.MyMainFrame;
import View.Panels.ScoreBoard.ScoreBoardPage;
import View.Panels.StatusPanel.StatusPage;

public class ClientMain {
    private static MyMainFrame myMainFrame = new MyMainFrame();

    public static MyMainFrame getMyMainFrame() {
        return myMainFrame;
    }


    public static void main(String[] args) {
        Client client = new Client("localhost", 1011);
        Controller.setCurrentClient(client);
        Controller.getCurrentClient().start();
        GraphicLoop.getInstance().start();
        myMainFrame.setContentPane(new LogInPage());
    }
}
