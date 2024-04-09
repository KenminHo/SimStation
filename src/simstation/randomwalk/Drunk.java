package simstation.randomwalk;

import mvc.*;
import simstation.*;
import java.awt.*;
import java.util.Iterator;

class Drunk extends Agent {

    boolean running = true;


    public Drunk() {
        super();
        heading = Heading.random();

    }

    public void update() {
        heading = Heading.random();
        int steps = Utilities.rng.nextInt(10) + 1;
        move(steps);
    }

    @Override
    public void start()
    {
        System.out.println("this runs");
        while(running) {
            update();
        }
    }

}