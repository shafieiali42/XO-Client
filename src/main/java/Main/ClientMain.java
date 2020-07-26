package Main;

import Client.Client;
import Controller.Controller;
import Util.Config.ConfigLoader;
import View.Loop.GraphicLoop;
import View.Models.BoardPanel;
import View.Panels.LogInPanel.LogInPage;
import View.Panels.MyMainFrame.MyMainFrame;
import View.Panels.ScoreBoard.ScoreBoardPage;
import View.Panels.StatusPanel.StatusPage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Properties;

public class ClientMain {
    private static MyMainFrame myMainFrame = new MyMainFrame();

    public static MyMainFrame getMyMainFrame() {
        return myMainFrame;
    }


    public static void main(String[] args)  {
        Properties properties = null;
        try {
            properties = ConfigLoader.getInstance().
                    readProperties("src/main/resources/ConfigFiles/PortConfig/PortConfig.properties");
        } catch (IOException e) {
            e.printStackTrace();
        }

        int serverPort;
        String configServerPort = (properties.getProperty("serverPort"));
        if (configServerPort==null){
            serverPort=8000;
        }else {
            serverPort=Integer.parseInt(configServerPort);
        }
        System.out.println(serverPort);

        Client client = new Client("localhost", serverPort);
        Controller.setCurrentClient(client);
        Controller.getCurrentClient().start();
        GraphicLoop.getInstance().start();
        myMainFrame.setContentPane(new LogInPage());
    }
}
