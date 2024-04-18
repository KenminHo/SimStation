package flocking;

import mvc.Utilities;
import simstation.Agent;

import java.awt.*;



public class Bird extends Agent {
    protected int speed;

    int neigh = 0;

    public Bird() {
        super();
        speed = Utilities.rng.nextInt(5) + 1;

    }

    public void update() {
        heading = Heading.random();
        Agent neighbor = world.getNeighbors(this, 10);
        if (neighbor != null) {
            Bird b = (Bird) neighbor;
            this.heading = b.heading;
            this.speed = b.speed;
        }

            move(speed);

    }

    @Override
    public Color getColor() {
        return Color.WHITE;
    }

    public int getHeading() {
        return this.heading.direction;
    }
}
