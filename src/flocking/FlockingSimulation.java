package flocking;

import mvc.AppPanel;
import mvc.*;
import simstation.Simulation;
import simstation.SimulationPanel;


public class FlockingSimulation extends Simulation{
    @Override
    public void populate() { //generating birds
        for(int i = 0; i < 40; i++)
            this.addAgent(new Bird());
    }
       @Override public void stats() {

                int num = 0;
                int num2 = 0;
                int num3 = 0;
                int num4 = 0;
                int num5 = 0;

                for(int j = 0; j < 40; j++) {
                    Bird hi = (Bird) agents.get(j);
                    if(hi.speed == 1){ num ++;}
                    else if(hi.speed == 2){ num2 ++;}
                    else if(hi.speed == 3){ num3 ++;}
                    else if(hi.speed == 4){ num4 ++;}
                    else if(hi.speed == 5){ num5 ++;}


                }
                Utilities.inform(new String[] {"#birds @ speed 1 = " + num,"#birds @ speed 2 = " + num2, "#birds @ speed 3 = " + num3,"#birds @ speed 4 = " + num4, "#birds @ speed 5 = " + num5});
        }
    public static void main(String[] args) {
        AppPanel panel = new SimulationPanel(new FlockingFactory());
        panel.display();
    }
}
