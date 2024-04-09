package simstation.randomwalk;

import mvc.*;
import simstation.Simulation;
import simstation.SimulationPanel;

public class RandomWalkSimulation extends Simulation {


   @Override
    public void populate() {
       System.out.println("The right populate works");
        for(int i = 0; i < 15; i++)
            addAgent(new Drunk());


    }

    public static void main(String[] args) {
        AppPanel panel = new SimulationPanel(new RandomWalkFactory());
        panel.display();
    }

}
