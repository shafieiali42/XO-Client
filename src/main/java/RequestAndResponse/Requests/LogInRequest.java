package RequestAndResponse.Requests;


import Model.Player.Player;
import RequestAndResponse.Response.LogInResponse;
import RequestAndResponse.Response.Response;

import com.google.gson.Gson;

import java.io.IOException;

public class LogInRequest extends Request {

    private String userName;
    private String password;
    private String mode; //SignUp or LogIn



    public LogInRequest(String applicator,String userName, String password, String mode) {
        this.setRequestType("LogInRequest");
        this.setApplicator(applicator);
        this.userName = userName;
        this.password = password;
        this.mode = mode;

    }



    @Override
    public void execute() {


    }


}
