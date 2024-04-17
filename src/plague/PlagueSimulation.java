package plague;
import simstation.*;
import mvc.*;

public class PlagueSimulation extends Simulation {
    @Override
    public void populate() {
        for(int i = 0; i < 15; i++)
            addAgent(new Hosts());
    }

    public static void main(String[] args) {
        AppPanel panel = new SimulationPanel(new PlagueFactory());
        panel.display();
    }
}
