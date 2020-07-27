package RequestAndResponse.Response;

import Controller.Controller;
import Model.Board.Board;

import java.util.ArrayList;

public class ScreenRecorderResponse extends Response {


    ArrayList<Board> boards;


    public ScreenRecorderResponse(ArrayList<Board> boards) {
        this.boards = boards;
    }


    @Override
    public void execute() {
        Controller.setBoards(boards);
        Controller.showScreenBoard(0);
    }


    //getter and setters
    //*********************

    public ArrayList<Board> getBoard() {
        return boards;
    }

    public void setBoard(ArrayList<Board> boards) {
        this.boards = boards;
    }


}
