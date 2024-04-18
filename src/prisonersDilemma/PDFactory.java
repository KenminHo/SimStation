package prisonersDilemma;
import simstation.*;
import mvc.*;

public class PDFactory extends SimulationFactory {
    @Override public String getTitle() { return "Prisoners Dilemma Simulator";}
    @Override public Model makeModel() { return new PDSimulation(); }
    @Override public View makeView(Model m) { return new PDView(m); }
    @Override public String[] getHelp() {return new String[] {"Simulation of prisoners dilemma"};}
    @Override public String about() {return null;}
}
