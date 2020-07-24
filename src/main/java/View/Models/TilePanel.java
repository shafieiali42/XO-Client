package View.Models;

import Controller.Controller;
import Model.Board.TileStatus;
import Util.Constants.Constant;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class TilePanel extends JPanel implements MouseListener {


    private int tileId;
    private boolean isOccupied;
    private TileStatus tileStatus;
    String message = "";

    public TilePanel(int tileId) {
        setSize(Constant.tileWidth, Constant.tileHeight);
        setBackground(Color.red);
        this.tileId = tileId;
        this.isOccupied = false;
        addMouseListener(this);
    }


    private void drawState(TileStatus tileStatus, Graphics2D g2d) {
        if (tileStatus != null) {
            if (tileStatus.equals(TileStatus.X)) {
                g2d.drawLine(0, 0, this.getWidth(), this.getHeight());
                g2d.drawLine(this.getWidth(), 0, 0, this.getHeight());
            } else if (tileStatus.equals(TileStatus.O)) {
                g2d.drawOval(this.getWidth() / 2, this.getHeight() / 2,
                        this.getWidth() / 2, this.getHeight() / 2);
            }
        }
    }


    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        setBackground(Color.red);
        g2d.drawString(message + "", 10, 10);
        g2d.drawLine(0, 0, 0, Constant.tileHeight);
        g2d.drawLine(0, 0, Constant.tileWidth, 0);
        g2d.drawLine(Constant.tileWidth, 0, Constant.tileWidth, Constant.tileHeight);
        g2d.drawLine(0, Constant.tileHeight, Constant.tileWidth, Constant.tileHeight);
        drawState(this.tileStatus, g2d);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (!isOccupied) {
            this.isOccupied = true;
            Controller.getCurrentClient().sendPlayPieceRequest(this.tileId);

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

    public TileStatus getTileStatus() {
        return tileStatus;
    }

    public void setTileStatus(TileStatus tileStatus) {
        this.tileStatus = tileStatus;
    }
}
