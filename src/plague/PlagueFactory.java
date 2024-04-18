package plague;
import simstation.*;
import mvc.*;

public class PlagueFactory extends SimulationFactory {
    public Model makeModel() { return new PlagueSimulation(); }
    public String getTitle() { return "Plague";}
    @Override
    public View makeView(Model m) {
        return new PlagueView(m);
    }
    @Override
    public String[] getHelp() {
        return new String[0];
    }
    @Override
    public String about() {
        return null;
    }

}
