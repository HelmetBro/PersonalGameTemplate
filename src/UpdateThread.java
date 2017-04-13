/**
 * Author: Eric Parsons
 */

class UpdateThread extends Thread {

    private Thread thread;
    private String threadName;

    private static boolean isRunning = true;

    //as the name suggests, these track instances of time. Elapsed time
    //is important concerning velocities and animations. (being a local
    //variables creates a better black box design).
    private long currentTime;
    private long previousTime;
    private double elapsedTime;

    public UpdateThread(String name){
        threadName = name;
    }

    @Override
    public void run() {

        while(isRunning) {

            /*
            * it's important that time is calculated in nanoseconds for two reasons:
            * one being that a detailed report of time is needed between cpu cycles.
            * Millisecond reports wouldn't work because most cpu cycles happen much
            * faster than a millisecond, meaning its average differentiation is a
            * constant zero. Nanoseconds provide enough information between cycles
            * that it's good enough to use for time-controlled stuff. Two, being
            * that a constant time function is required. Cpu ticks don't
            * occur on a scale, meaning the elapsed time from one point could be
            * a smaller number, but in reality take longer to complete.
            */

            //grabs current time in nano seconds from system computer
            currentTime = System.nanoTime();

            //finds total elapsed time in seconds from current and previous times
            elapsedTime = (currentTime - previousTime) / 1000000000d;

            /*
            * yield() is important for v-sync issues. This lets DrawThread get
            * ahead in its register in the cpu, meaning it assures that Draw();
            * gets called and executed when needed, instead of waiting for this
            * threads' register to finish. This is important for older computers
            * but not needed as much for computers with higher cores.
            */
            Thread.yield();

            switch (Game.state) {
                case 0:
                    Game.startScreen.Update(elapsedTime);
                    break;
                case 1:
                    Game.gameScreen.Update(elapsedTime);
                    break;
                default:
                    System.out.println("Game state not defined in Update()!");
                    break;
            }//switch/case

            previousTime = currentTime;

        }//while
    }//run

    @Override
    public void start() {

        if (thread == null) {
            thread = new Thread(this, threadName);
            thread.start ();
        }

        //initializing previous time here dictate an appropriate
        //elapsed time on first loop in the while
        previousTime = System.nanoTime();

    }

    public void kill() {
        isRunning = false;
    }

}//class
