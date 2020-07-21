package View.Models;

import Util.Constants.Constant;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Tile extends JPanel implements MouseListener {


    private int tileId;
    private boolean isOccupied;
    private String state;

    public Tile(int tileId) {
        setSize(Constant.tileWidth, Constant.tileHeight);
        this.tileId = tileId;
        this.isOccupied = false;
    }


    private void drawState(String state, Graphics2D g2d) {
        if (state.equalsIgnoreCase("X")) {
            g2d.drawLine(0, 0, this.getWidth(), this.getHeight());
            g2d.drawLine(this.getWidth(), 0, 0, this.getHeight());
        } else if (state.equalsIgnoreCase("O")) {
            g2d.drawOval(this.getWidth() / 2, this.getHeight() / 2,
                    this.getWidth() / 2, this.getHeight() / 2);
        }
    }


    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        drawState(this.state, g2d);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (!isOccupied) {
            this.isOccupied = true;


        }


    }


    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }


    //getter and setters
    //********************

    public int getTileId() {
        return tileId;
    }

    public void setTileId(int tileId) {
        this.tileId = tileId;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
