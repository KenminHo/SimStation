package flocking;
import simstation.Agent;
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
