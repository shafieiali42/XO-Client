package View.Models;

import Util.Constants.Constant;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class BoardPanel extends JPanel {

    private ArrayList<TilePanel> tilePanels;

    public BoardPanel() {
        setLayout(new GridLayout(7, 7));
        setSize(Constant.boardWidth,Constant.boardHeight);
        setBackground(Color.yellow);
        tilePanels =new ArrayList<>();
        initTiles();
        drawBoard();



    }


    private void initTiles() {
        for (int i = 0; i < 49; i++) {
            TilePanel tilePanel =new TilePanel(i);
            this.tilePanels.add(tilePanel);
        }
    }

    private void drawBoard(){
        for (TilePanel tilePanel :this.tilePanels){
            this.add(tilePanel);
        }
    }


    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
//        this.removeAll();
//        drawBoard();
//        setBackground(Color.yellow);
    }




    //getter and setters
    //********************

    public ArrayList<TilePanel> getTilePanels() {
        return tilePanels;
    }

    public void setTilePanels(ArrayList<TilePanel> tilePanels) {
        this.tilePanels = tilePanels;
    }


}
