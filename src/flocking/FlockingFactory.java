package flocking;

import mvc.Model;
import simstation.SimulationFactory;

public class FlockingFactory extends SimulationFactory {
    @Override public String getTitle() { return "Flocking Simulator";}
    @Override public Model makeModel() { return new FlockingSimulation(); }

    /*    @Override public String[] getHelp() { return new String[] {"About", "Help"}; }*/
    /*    @Override public String about() { return "Flocking Simulation " +
            "\n CS151 Group 11 \n Kenmin Ho, Taras Tishchenko"; }*/
    @Override
    public String[] getHelp() {
        return new String[0];
    }
    @Override
    public String about() {
        return null;
    }
}
