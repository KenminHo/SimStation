package plague;
import mvc.Utilities;
import simstation.Agent;

import java.awt.*;

public class Hosts extends Agent {

    protected Color color = Color.GREEN;

    protected boolean immunity = false;

    public Hosts(Color color, Boolean immunity) {
        super();
        this.color = color;
        this.immunity = immunity;


    }


    public Color getColor (){
        return this.color;
    }


    public void update() {
        Agent neighbor = world.getNeighbors(this, 5);
        if (neighbor != null)
        {
            if(neighbor.getColor() == Color.RED && !immunity && this.color == Color.GREEN) {
                this.color = Color.RED;
            }
        }




        heading = Heading.random();
        int steps = Utilities.rng.nextInt(10) + 1;
        move(steps);

    }
}
