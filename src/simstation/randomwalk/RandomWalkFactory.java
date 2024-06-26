package simstation.randomwalk;

import mvc.*;
import simstation.SimulationFactory;

import javax.swing.*;

public class RandomWalkFactory extends SimulationFactory {
    public Model makeModel() { return new RandomWalkSimulation(); }
    public String getTitle() { return "Random Walks";}



    @Override
    public String[] getHelp() {
        return new String[]{"A simulation where the people move in random directions"};
    }

    @Override
    public String about() {
        return null;
    }


}
