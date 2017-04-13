/**
 * Author: Eric Parsons
 */

import javax.swing.*;

public class Game extends JFrame{

    //window keeps track of game state. Can also be an enum instead of byte.
    static byte state;

    //has static references of game states. These don't have to be initialized,
    //just a global reference is need.
    static StartScreen startScreen;
    static GameScreen gameScreen;

    //references to both threads as well
    final UpdateThread updateThread;
    final DrawThread drawThread;

    Game(){
        super("[name of the window here]");

        //Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        //creates instances of all states and threads
        LoadContent();

        //adding the current state (which is a panel) to the window
        this.add(startScreen);

        //creating and running base threads
        updateThread = new UpdateThread("Update Thread");
        drawThread = new DrawThread("Draw Thread");

        updateThread.start();
        drawThread.start();
    }

    private void LoadContent(){
        //state 0 is startScreen state
        state = 0;

        startScreen = new StartScreen();
        gameScreen = new GameScreen();

        startScreen.LoadContent();
        gameScreen.LoadContent();
    }

}
