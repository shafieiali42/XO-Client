package RequestAndResponse.Response;


import Controller.Controller;
import Main.ClientMain;
import Model.Player.Player;
import View.Panels.MainMenu.MainMenuPage;


import javax.swing.*;

public class LogInResponse implements Response {

    private Player player;


    public LogInResponse(Player player) {
        this.player = player;
    }


    @Override
    public void execute() {
        if (player != null) {
            Controller.getCurrentClient().setPlayer(player);
            ClientMain.getMyMainFrame().setContentPane(new MainMenuPage());
        } else {
            JOptionPane.showMessageDialog(null, "LogInError", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }


    //getter and setters
    //*********************

    public Player getPlayer() {
        return player;
    }
    public void setPlayer(Player player) {
        this.player = player;
    }


}
