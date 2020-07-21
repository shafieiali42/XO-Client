package View.Models;

import Util.Constants.Constant;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class BoardPanel extends JPanel {

    private ArrayList<Tile> tiles;

    public BoardPanel() {
        super(new GridLayout(7, 7));
        initTiles();
        drawBoard();
        setSize(Constant.boardWidth,Constant.boardHeight);


    }


    private void initTiles() {
        for (int i = 0; i < 49; i++) {
            Tile tile=new Tile(0);
            this.tiles.add(tile);
        }
    }

    private void drawBoard(){
        for (Tile tile:this.tiles){
            this.add(tile);
        }
    }


    @Override
    protected void paintComponent(Graphics g) {
        this.removeAll();
        drawBoard();
        repaint();
        revalidate();
    }







}
