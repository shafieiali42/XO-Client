package RequestAndResponse.Response;


import Controller.Controller;
import Main.ClientMain;
import Model.Player.Player;
import View.Panels.MainMenu.MainMenuPage;


import javax.swing.*;

public class LogInResponse extends Response {

    private Player player;
    private boolean logInBefore;

    public LogInResponse(Player player, String authtoken, boolean logInBefore) {
        this.setReceiver(authtoken);
        this.player = player;
        this.logInBefore = logInBefore;
    }


    @Override
    public void execute() {
        if (player != null) {
            if (logInBefore) {
                JOptionPane.showMessageDialog(null,
                        "This account has already been logged in",
                        "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                Controller.getCurrentClient().setPlayer(player);
                Controller.getCurrentClient().setAuthtoken(this.getReceiver());
                ClientMain.getMyMainFrame().setContentPane(new MainMenuPage());
            }
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

    public boolean isLogInBefore() {
        return logInBefore;
    }

    public void setLogInBefore(boolean logInBefore) {
        this.logInBefore = logInBefore;
    }

}
