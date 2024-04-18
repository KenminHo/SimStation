package simstation.randomwalk;

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
       Utilities.inform(new String[]{"#Agents = " + agents.size(), "clock = " + clock});
    }


    public static void main(String[] args) {
        AppPanel panel = new SimulationPanel(new RandomWalkFactory());
        Simulation world = new Simulation();
        world.populate();
        panel.display();

    }

}
