/**
 * Author: Eric Parsons
 */

import javax.swing.*;
import java.awt.*;

public class StartScreen extends JPanel {

    //take a look at GameScreen class first.

    public StartScreen(){
        super();
    }

    public void Update(double elapsedTime){

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        //formatting paint component
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
    }

    public void Draw(){
        repaint();
    }

    //method to change states. Add this in an action listener.
    private void checkToStartGame(){

        if (true/*replace with condition that determines game should change state to another*/){

            //changes the state so threads know what to start running
            Game.state = 1;

            //removes current state from window. This is why keeping that global reference is so important.
            Program.gameWindow.remove(Game.startScreen);

            //...and adds the next state the window
            Program.gameWindow.add(Game.gameScreen);

            //revalidate to make sure we make edits to gameScreen, not startScreen
            Game.gameScreen.revalidate();
        }

    }

    public void LoadContent(){

    }
}//class
