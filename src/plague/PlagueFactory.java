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
        return new String[]{"A simulation where living people (green) get infected by infected people (red)"};
    }
    @Override
    public String about() {
        return null;
    }

}
