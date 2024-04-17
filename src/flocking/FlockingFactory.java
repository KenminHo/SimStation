package flocking;

import mvc.Model;
import simstation.SimulationFactory;

public class FlockingFactory extends SimulationFactory {
    public Model makeModel() { return new FlockingSimulation(); }
    public String getTitle() { return "Flocking";}
    @Override
    public String[] getHelp() {
        return new String[0];
    }
    @Override
    public String about() {
        return null;
    }
}
