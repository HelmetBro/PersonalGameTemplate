/**
 * Author: Eric Parsons
 */

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Program {

    //has static instance of window
    public static Game gameWindow;

    public static void main(String[] args) {

        //creating game window
        gameWindow = new Game();

        gameWindow.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        gameWindow.setExtendedState(JFrame.MAXIMIZED_BOTH);
        gameWindow.setUndecorated(true);
        gameWindow.setVisible(true);


        //how to stop game:

        //option to close when escape key hit.
        gameWindow.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent ke) {  //handler
                if(ke.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    gameWindow.dispose();

                    //safely stops the threads
                    gameWindow.updateThread.kill();
                    gameWindow.drawThread.kill();

                    System.out.println("Program closed.");
                }
            }
        });



    }//main
}//Program
