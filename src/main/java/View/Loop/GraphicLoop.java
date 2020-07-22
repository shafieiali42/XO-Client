package View.Loop;

import Client.Client;
import Main.ClientMain;



public class GraphicLoop extends Loop {

    private static GraphicLoop graphicLoop = new GraphicLoop(60);
    public static GraphicLoop getInstance() {
        return graphicLoop;
    }


    public GraphicLoop(int fps) {
        super(fps);
    }

    @Override
    public void update() {

        ClientMain.getMyMainFrame().repaint();
        ClientMain.getMyMainFrame().revalidate();
//        GamePage.getInstance().repaint();
//        GamePage.getInstance().revalidate();
    }
}
