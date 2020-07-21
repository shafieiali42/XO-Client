package RequestAndResponse.Requests;

import Client.Client;
import Controller.Controller;
import Model.Player.Player;
import RequestAndResponse.Response.LogInResponse;
import RequestAndResponse.Response.Response;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class LogInRequest implements Request {

    private String userName;
    private String password;
    private String mode; //SignUp or LogIn


    public LogInRequest(String userName, String password, String mode) {
        this.userName = userName;
        this.password = password;
        this.mode = mode;
    }


    public static boolean signUp(String userName, String passWord) throws IOException {

        Type type = new TypeToken<List<Player>>() {
        }.getType();
        List<Player> playerList = new Gson().fromJson(new FileReader("Players/AllPlayers.json"), type);
        boolean canSignUp = true;
        for (Player player : playerList) {
            if (userName.equals(player.getUserName())) {
                canSignUp = false;
            }
        }
        if (canSignUp) {
            Player player = new Player(userName, passWord);
             Client fuck=Controller.getCurrentClient();
            Controller.getCurrentClient().setPlayer(player);
            return true;
        } else {
            return false;
        }
    }

    public static boolean signIn(String userName,String passWord) throws IOException {
        Type type = new TypeToken<List<Player>>() { }.getType();
        List<Player> playerList = new Gson().fromJson(new FileReader("Players/AllPlayers.json"), type);
        boolean valiUserNameAndPassword = false;
        for (Player player : playerList) {
            if (userName.equals(player.getUserName()) && passWord.equals(player.getPassword())) {
                valiUserNameAndPassword = true;
                Controller.getCurrentClient().setPlayer(player);
                return true;
            }
        }
        return false;
    }



    @Override
    public void execute() {
        if (this.mode.equalsIgnoreCase("SignUp")) {
            try {
                if (signUp(userName,password)){
                    Response response =new LogInResponse(true,"successful");
                }else {
                    Response response =new LogInResponse(false,"There is an account with this username!");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }


        } else if (this.mode.equalsIgnoreCase("LogIn")) {
            try {
                if (signIn(userName,password)){
                    Response response=new LogInResponse(true,"successful");
                }else {
                    Response response =new LogInResponse(false,"Please Enter a Valid UserName or Password!");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    @Override
    public String getRequestType() {
        return "LogInRequest";
    }

}
