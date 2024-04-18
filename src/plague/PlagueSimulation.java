package plague;
import simstation.*;
import mvc.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;

public class PlagueSimulation extends Simulation {

    public static int VIRULENCE = 50; // % chance of infection
    public static int RESISTANCE = 2; // % chance of resisting infection
    public int infected = 0; // # of infected

    public static int POPULATIONSIZE = 50;
    int numberOfImmunity = (RESISTANCE * POPULATIONSIZE)/100;
    int numberOfInfected = (VIRULENCE * POPULATIONSIZE)/100;


    @Override
    public void populate() {
        ArrayList<Integer> selection = new ArrayList<>();


        for (int i = 0; i < POPULATIONSIZE; i++) { // Adjust the range as needed
            selection.add(i);
        }
        Collections.shuffle(selection);


        for (int i = 0; i < numberOfImmunity; i++) { // Adjust the range as needed
            addAgent(new Hosts(Color.GREEN, true));

        }
        for (int i = 0; i < numberOfInfected; i++) { // Adjust the range as needed
            addAgent(new Hosts(Color.RED, false));
        }


        int remaining = POPULATIONSIZE - (numberOfInfected + numberOfImmunity);
        for(int i = 0; i < remaining; i++)
            addAgent(new Hosts(Color.GREEN,false));
    }

    @Override
    public void stats() {
        Utilities.inform(new String[]{"#Agents = " + agents.size(), "clock = " + clock, "% infected = " + infected});
    }

    public static void main(String[] args) {
        AppPanel panel = new SimulationPanel(new PlagueFactory());
        panel.display();

    }
}
