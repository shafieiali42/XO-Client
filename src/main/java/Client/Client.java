package Client;

import Model.Player.Player;
import RequestAndResponse.Requests.LogInRequest;
import RequestAndResponse.Requests.Request;
import RequestAndResponse.Requests.JsonDeSerializerForRequest;
import RequestAndResponse.Response.JsonDeSerializerForResponse;
import RequestAndResponse.Response.Response;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class Client  extends Thread{


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
        int counter=0;
        try {
            Scanner myScanner=new Scanner(socket.getInputStream());
            String authtoken="";
            String responseName="";
            String message="";

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
                        Response response = JsonDeSerializerForResponse.deSerializeResponse(responseName, message);
                        this.responses.add(response);
                        executeResponse();
                        break;
                }
                counter++;


            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void executeResponse(){
        for (Response response:responses){
            response.execute();
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
            printStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void sendLogInRequest(String userName, String password, String mode) {
        Request request = new LogInRequest(userName, password, mode);
        String message = new Gson().toJson(request);
        sendRequest(authtoken,"LogInRequest",message);
    }


    //getter and setters
    //********************

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }


}
