package flocking;

import mvc.Utilities;
import simstation.Agent;

import java.awt.*;

//speed: int; update() => simstation.Agent()

public class Bird extends Agent{
    public Bird(){
        super();
        heading = Heading.random();
    }

    public void update(){
        heading = Heading.random();
        int steps = Utilities.rng.nextInt(10) + 1;
        move(steps);
    }

    @Override
    public Color getColor() {
        return Color.WHITE;
    }

    public void start(){
        while(true){
            update();
            try{
                Thread.sleep(100);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
