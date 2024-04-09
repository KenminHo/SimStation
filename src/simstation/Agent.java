package simstation;

import mvc.Model;
import mvc.Publisher;
import mvc.Utilities;

import java.io.Serializable;
import java.util.ArrayList;
import java.awt.*;
import java.util.Iterator;

public abstract class Agent extends Publisher implements Serializable, Runnable {

    private String name;
    protected Heading heading;
    protected int xc;
    protected int yx;
    private boolean suspended = false;
    private boolean stopped = false;
    protected transient Thread thread;

    protected Simulation world;

    public void run() {
        start();
        stop();

    }

    public abstract void start();


    public void suspend() {

    }

    public void resume() {

    }

    public void stop() {

    }

    public void update() {

    }

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
