package View.Panels.MyMainFrame;

import Util.Constants.Constant;
import javax.swing.*;

public class MyMainFrame extends JFrame {


    private int width;
    private int height;

    public MyMainFrame(){
        this.initFrame();
    }

    private void initFrame() {
        this.loadFrame();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    private void loadFrame() {
        width=Constant.widthOfMainFrame;
        height=Constant.heightOfMainFrame;
        setDefaultCloseOperation(Constant.defaultCloseOperation);
        setResizable(Constant.resizable);
        setSize(width, height);
    }


}
