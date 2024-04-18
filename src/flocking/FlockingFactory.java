package flocking;

import mvc.Model;
import simstation.SimulationFactory;

public class FlockingFactory extends SimulationFactory {
    @Override public String getTitle() { return "Flocking Simulator";}
    @Override public Model makeModel() { return new FlockingSimulation(); }

    @Override
    public String[] getHelp() {
        return new String[]{"Creates a simulation of birds flocking"};
    }
    @Override
    public String about() {
        return null;
    }
}
