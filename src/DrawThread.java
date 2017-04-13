/**
 * Author: Eric Parsons
 */

import java.awt.*;

class DrawThread extends Thread {

    private Thread thread;
    private String threadName;

    private static boolean isRunning = true;

    private short defaultRefreshRate = 60;
    private int currentRefreshRate;

    public DrawThread(String name){
        threadName = name;
        getCurrentRefreshRate();
    }

    @Override
    public void run() {

        while(isRunning) {

            try {
                Thread.sleep(1000 / currentRefreshRate);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            switch (Game.state) {
                case 0:
                    Game.startScreen.Draw();
                    break;
                case 1:
                    Game.gameScreen.Draw();
                    break;
                default:
                    System.out.println("Game state not defined in Draw()!");
                    break;
            }
        }//while
    }//run method

    @Override
    public void start() {

        if (thread == null) {
            thread = new Thread(this, threadName);
            thread.start ();
        }

    }

    private void getCurrentRefreshRate(){

        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice[] gs = ge.getScreenDevices(); //array of all graphics devices

        //iterates through all display devices for multi-monitor support. Gets main one.
        for (GraphicsDevice g : gs) {
            DisplayMode dm = g.getDisplayMode();

            currentRefreshRate = dm.getRefreshRate();
            if (currentRefreshRate == DisplayMode.REFRESH_RATE_UNKNOWN) {
                System.out.println("Unknown refresh rate.");
                currentRefreshRate = defaultRefreshRate; //default
            }

            //also capable of getting the bit-depth
            //int bitDepth = dm.getBitDepth();
            //int numColors = (int) Math.pow(2, bitDepth);

        }//for
    }

    public void kill() {
        isRunning = false;
    }

}//class
