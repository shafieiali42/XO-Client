package RequestAndResponse.Response;

import Controller.Controller;
import Main.ClientMain;

import View.Panels.MainMenu.MainMenuPage;



public class EndGameResponse extends Response {


    public EndGameResponse() {


    }


    @Override
    public void execute() {
        System.out.println("execute end game response"+ Controller.getCurrentClient().getPlayer().getUserName());
        ClientMain.getMyMainFrame().setContentPane(new MainMenuPage());

    }

}
