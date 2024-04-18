package simstation.randomwalk;

import flocking.Bird;
import mvc.*;
import simstation.Simulation;
import simstation.SimulationPanel;

import java.awt.*;

public class RandomWalkSimulation extends Simulation {


   @Override
    public void populate() {
       System.out.println("The right populate works");
        for(int i = 0; i < 15; i++)
            addAgent(new Drunk());


    }

    @Override
        public void stats() {

        int num = 0;
        int num2 = 0;
        int num3 = 0;
        int num4 = 0;
        int num5 = 0;

        int head = 0;
        int head2 = 0;
        int head3 = 0;
        int head4 = 0;

        for(int j = 0; j < 15; j++) {
            Drunk hi = (Drunk) agents.get(j);

            if(hi.getHeading() == 0){ head ++;}
            else if(hi.getHeading() == 1){ head2 ++;}
            else if(hi.getHeading() == 2){ head3 ++;}
            else if(hi.getHeading() == 3){ head4 ++;}
        }
        Utilities.inform(new String[] {"#birds @ speed 1 = " + num,"#birds @ speed 2 = " + num2, "#birds @ speed 3 = " + num3,"#birds @ speed 4 = " + num4, "#birds @ speed 5 = " + num5, "#birds @ head  = " + head, "#birds @ head 2 = " + head2, "#birds @ head 3 = " + head3, "#birds @ head 4 = " + head4});
    }


    public static void main(String[] args) {
        AppPanel panel = new SimulationPanel(new RandomWalkFactory());
        Simulation world = new Simulation();
        world.populate();
        panel.display();

    }

}
