package RequestAndResponse.Response;

import Controller.Controller;
import Main.ClientMain;
import View.Panels.LogInPanel.LogInPage;

public class LogOutResponse extends Response  {

    private boolean success;

    public LogOutResponse(boolean success){
        this.success=success;
    }

    @Override
    public void execute() {
        if (this.success){
            Controller.getCurrentClient().setAuthtoken(null);
            Controller.getCurrentClient().setPlayer(null);
            ClientMain.getMyMainFrame().setContentPane(new LogInPage());
        }
    }


    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
