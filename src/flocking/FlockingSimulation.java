package flocking;

import mvc.AppPanel;
import simstation.Simulation;
import simstation.SimulationPanel;
//populate(); getStarted(): String()  => simstation.Simulation => mvc.Model

public class FlockingSimulation extends Simulation{
    @Override
    public void populate() { //generating birds
        for(int i = 0; i < 40; i++)
            this.addAgent(new Bird());
    }
    /*    @Override public void stats() {
            for (int i = 0; i <5; i++) {
                Utilities.inform(new String[] {"# of birds at speed " + i+1 + " = " +
                        //agents.stream().filter(a -> ((Bird) a).speed == i).count()
                        agents.stream().filter(Bird().getSpeed() == i+1).count()
                });
        }
        }*/
    public static void main(String[] args) {
        AppPanel panel = new SimulationPanel(new FlockingFactory());
        panel.display();
    }
}
