package Client;

import Model.Player.Player;
import RequestAndResponse.Requests.*;
import RequestAndResponse.Response.JsonDeSerializerForResponse;
import RequestAndResponse.Response.Response;
import Util.Constants.Constant;
import Util.OtherClasses.LengthOfMessage;
import com.google.gson.Gson;

import java.awt.*;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Client extends Thread {


    private Player player;
    private String serverIp;
    private int serverPort;
    private Socket socket;
    private ArrayList<Response> responses;
    private String authtoken;

    public Client() {
        this.responses = new ArrayList<>();
    }

    public Client(String serverIp, int serverPort) {
        try {
            socket = new Socket(serverIp, serverPort);
            this.responses = new ArrayList<>();
            authtoken = null;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Client(Player player) {
        super();
        this.player = player;
    }


    @Override
    public void run() {
        int counter = 0;
        try {
            Scanner myScanner = new Scanner(socket.getInputStream());
            String authtoken = "";
            String responseName = "";
            String message = "";
            while (true) {
                while (myScanner.hasNextLine()) {
                    String text = myScanner.nextLine();

                    switch (counter % 3) {
                        case 0:
                            authtoken = text;
                            break;
                        case 1:
                            responseName = text;
                            break;
                        case 2:
                            message = text;
                            Response response = JsonDeSerializerForResponse.deSerializeResponse(authtoken, responseName, message);
                            this.responses.add(response);
                            executeResponse();
                            break;
                    }
                    counter++;


                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void executeResponse() {
        Iterator<Response> itr = responses.iterator();
        while (itr.hasNext()) {
            Response response = itr.next();
            response.execute();
            itr.remove();
        }
    }


    private void sendRequest(String authtoken, String requestName, String request) {
        PrintStream printStream = null;
        try {
            printStream = new PrintStream(socket.getOutputStream());
            printStream.println(authtoken);
            printStream.println(requestName);
            printStream.println(request);
            printStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public void sendPlayPieceRequest(int targetTileId){
        System.out.println("send play piece request");
        Request request=new PlayPieceRequest(authtoken,targetTileId);
        String message =new Gson().toJson(request);
        sendRequest(authtoken,"PlayPieceRequest",message);

    }


    public void sendPlayRequest(){
        System.out.println("send play request");
        Request request=new PlayRequest(authtoken);
        String message=new Gson().toJson(request);
        sendRequest(authtoken,"PlayRequest",message);
    }

    public void sendLogOutRequest() {
        System.out.println("send logout request");
        Request request = new LogOutRequest(this.authtoken);
        String message = new Gson().toJson(request);
        sendRequest(authtoken, "LogOutRequest", message);

    }

    public void sendLogInRequest(String userName, String password, String mode) {
        Request request = new LogInRequest(authtoken, userName, password, mode);
        String message = new Gson().toJson(request);
        sendRequest(authtoken, "LogInRequest", message);
    }


    public void sendShowScoreBoardRequest(){
        Request request=new ScoreBoardRequest(authtoken);
        String message=new Gson().toJson(request);
        sendRequest(authtoken,"ScoreBoardRequest",message);
    }


    //getter and setters
    //********************

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public String getAuthtoken() {
        return authtoken;
    }

    public void setAuthtoken(String authtoken) {
        this.authtoken = authtoken;
    }
}
