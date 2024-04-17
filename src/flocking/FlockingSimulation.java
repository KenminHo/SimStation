package flocking;
import simstation.*;
import mvc.*;
//populate(); getStarted(): String()  => simstation.Simulation => mvc.Model

public class FlockingSimulation extends Simulation{
    @Override
    public void populate() {
        for(int i = 0; i < 15; i++)
            addAgent(new Bird());
    }

    public static void main(String[] args) {
        AppPanel panel = new SimulationPanel(new FlockingFactory());
        panel.display();
    }
}
