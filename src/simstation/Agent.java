package simstation;

import mvc.Publisher;
import mvc.Utilities;

import java.io.Serializable;

public abstract class Agent extends Publisher implements Serializable, Runnable {

    private String name;
    protected Heading heading;
    protected int xc = Utilities.rng.nextInt(0,250);
    protected int yx = Utilities.rng.nextInt(0,250);
    private boolean suspended = false;
    private boolean stopped = false;
    protected transient Thread thread;

    protected Simulation world;

    public void setWorld(Simulation w) {world = w;}

    public void run() {
        thread = Thread.currentThread();
        while (!stopped) {
            try {
                update();
                Thread.sleep(1000);
                suspended = true;
            } catch(InterruptedException e) {
                System.out.println(e.getMessage());
            }
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
       stopped = false;
       run();
    }

    public synchronized void stop() {
        stopped = true;
    }

    public abstract void update();

    public void move(int steps) {
        for (int i = 0; i < steps; i ++) {
            if (Heading.direction == 1) {
                xc += 1;
            } else if (Heading.direction == 2) {
                yx += -1;
            } else if (Heading.direction == 3) {
                xc += -1;
            } else if (Heading.direction == 4) {
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
            return test;


        }
    }
}
