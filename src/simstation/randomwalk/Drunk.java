package simstation.randomwalk;

import mvc.*;
import simstation.*;

import java.awt.*;

class Drunk extends Agent {

    public Drunk() {
        super();
    }

    @Override
    public Color getColor() {
        return Color.WHITE;
    }

    public void update() {
        heading = Heading.random();
        int steps = Utilities.rng.nextInt(10) + 1;
        move(steps);
    }

    public int getHeading() {

       return heading.direction;
    }

}