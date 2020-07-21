package Main;

import Client.Client;
import Controller.Controller;
import View.Panels.LogInPanel.LogInPage;
import View.Panels.MyMainFrame.MyMainFrame;

public class ClientMain {
    private static MyMainFrame myMainFrame = new MyMainFrame();

    public static MyMainFrame getMyMainFrame() {
        return myMainFrame;
    }

    public static void setMyMainFrame(MyMainFrame myMainFrame) {
        ClientMain.myMainFrame = myMainFrame;
    }

    public static void main(String[] args) {
        Client client = new Client("localhost", 8585);
        Controller.setCurrentClient(client);
        myMainFrame.setContentPane(new LogInPage());

    }
}
