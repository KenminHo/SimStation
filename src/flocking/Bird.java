package flocking;

import mvc.*;
import simstation.*;

//speed: int; update() => simstation.Agent()

public class Bird extends Agent{
    private int speed;
    public Bird(){ super();
        this.heading = Heading.random();
        this.speed = Utilities.rng.nextInt(5) + 1;
        //setSpeed(getSpeed());
    }
    @Override public void update(){
        //heading = Heading.random();
        Agent neighbor = world.getNeighbors(this, 10);
        if(neighbor != null && neighbor instanceof Bird){
            Bird b = (Bird) neighbor;
            this.heading = b.heading;
            this.speed = b.speed;
        }
        move(speed);

    }
    public int getSpeed(){
        //speed = Utilities.rng.nextInt(5) + 1;
        return speed;
    }
/*    public void setSpeed(int speed){
        this.speed = speed;
    }*/

   /* public void start(){
        while(true){
            update();
            try{
                Thread.sleep(100);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }*/
}
