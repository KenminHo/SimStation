package flocking;

import mvc.*;
import simstation.*;

public class FlockingFactory extends SimulationFactory {
    @Override public String getTitle() { return "Flocking Simulator";}
    @Override public Model makeModel() { return new FlockingSimulation(); }

/*    @Override public String[] getHelp() { return new String[] {"About", "Help"}; }*/
/*    @Override public String about() { return "Flocking Simulation " +
            "\n CS151 Group 11 \n Kenmin Ho, Taras Tishchenko";
    }*/
}
