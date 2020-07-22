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
        Client client = new Client("localhost", 1010);
        Controller.setCurrentClient(client);
        Controller.getCurrentClient().start();
        myMainFrame.setContentPane(new LogInPage());

    }
}
