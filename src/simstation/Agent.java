package simstation;

import mvc.Publisher;
import mvc.Utilities;

import java.awt.*;
import java.io.Serializable;

public abstract class Agent extends Publisher implements Serializable, Runnable {

    private String name;
    protected Heading heading;
    protected int xc = Utilities.rng.nextInt(25,225);
    protected int yx = Utilities.rng.nextInt(25,225);
    private boolean suspended = false;
    private boolean stopped = false;
    protected transient Thread thread;

    protected Simulation world;

    public void setWorld(Simulation w) {world = w;}

    public abstract Color getColor();

    public void run() {
        thread = Thread.currentThread();
        checkSuspended();
        onStart();
        while (!stopped) {
            try {
                update();
                Thread.sleep(50);
                checkSuspended();
            } catch (InterruptedException e) {
                Utilities.error(e);
            }
        }
        onExit();

    }

    private void onExit() {
    }

    private void onInterrupted() {
    }

    private void onStart() {
    }

    private synchronized void checkSuspended() {
        try {
            while(!stopped && suspended) {
                wait();
                suspended = false;
            }
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }


    public synchronized void start() {
        stopped = false;
        run();
    }


    public synchronized void suspend() {
        suspended = true;
    }

    public synchronized void resume() {
       suspended = false;


    }

    public synchronized void stop() {
        stopped = true;
    }

    public abstract void update();

    public void move(int steps) {
        for (int i = 0; i < steps; i ++) {
            if (Heading.direction == 0) {
                xc += 1;
            } else if (Heading.direction == 1) {
                yx += -1;
            } else if (Heading.direction == 2) {
                xc += -1;
            } else if (Heading.direction == 3) {
                yx += 1;
            }
            world.changed();
        }
    }

    protected static class Heading {

        public static int direction;
        static Heading test = new Heading();
        public Heading() {
            int direction = 0;
        }

        public static Heading random() {
            direction = Utilities.rng.nextInt(4);
         //   System.out.println(direction);
            return test;


        }
    }
}
