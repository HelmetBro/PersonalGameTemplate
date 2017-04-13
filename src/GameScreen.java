/**
 * Author: Eric Parsons
 */

import javax.swing.*;
import java.awt.*;

public class GameScreen extends JPanel {

    public GameScreen(){
        super();

        //initialize only global variables here. Leave all other stuff
        //to LoadContent()- it looks better and is better practice
    }

    public void Update(double elapsedTime){
        /*
        * stuff here happens every cpu cycle. Use this for updating coordinates,
        * getting time-relative calculations (speed, velocity, etc.) and other logic
        * based algorithms. Anything that doesn't have to do with drawing objects or
        * uses paintComponent.
        *
        * elapsedTime is the time difference between every cpu cycle in seconds. Used
        * for updating positions. ex:
        *       position.X += velocity.X * elapsedTime;
        *       position.Y += velocity.Y * elapsedTime;
        */
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        //formatting paint component. I wouldn't touch this because anti-aliasing
        //always looks nice, especially in swing. Circles look 10x better.
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

    }

    public void Draw(){
        repaint(); //calls paintComponent

        /*
        * this happens every cycle of the screen refresh rate. Don't add any logic here
        * aside from drawing objects and other drawing stuff.
        */

    }

    public void LoadContent(){
        //load sprites and other stuff here. Anything needed to be initialized.
    }
}
