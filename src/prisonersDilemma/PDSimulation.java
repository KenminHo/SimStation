package prisonersDilemma;
import plague.PlagueFactory;
import simstation.*;
import mvc.*;

import java.awt.*;
import java.util.*;

public class PDSimulation extends Simulation {

    public Color grabColor(int i) {
        if (i == 0) {
            return Color.green;
        }
        if (i == 1) {
            return Color.cyan;
        }
        if (i == 2) {
            return Color.orange;
        }
        if (i == 3) {
            return Color.red;
        }

        return Color.white;
    }

    @Override
    public void populate() {

        int tracker = 0;
        for (int i = 0; i < 40; i++) {

            Strategy s = switch (i % 4) {
                case 0 -> new Strategy.alwaysCooperate();
                case 1 -> new Strategy.randomlyCooperate();
                case 2 -> new Strategy.alwaysCheat();
                case 3 -> new Strategy.tit4tat();
                default -> null;
            };

            addAgent(new Prisoner("P# " + i, s, grabColor(tracker)));

            if (tracker == 4) {
                tracker = 0;
            }
            tracker++;
        }
    }

    public void stats() {
        int totalFitness = 0;

        int totalCheaters = 0;
        int totalCooperators = 0;
        int totalRandoms = 0;
        int totalTit4Tats = 0;

        int cheatCounter = 0;
        int coopCounter = 0;
        int rndCounter = 0;
        int t4tCounter = 0;

        for (Agent agent: agents) {
            if (aa instanceof Prisoner) {
                Prisoner p = (Prisoner) aa;
                //totalFitness += p.getFit();
                totalFitness = p.getFit();
                Strategy strat = p.getStrat();

                if (strat instanceof Strategy.alwaysCooperate) {
                    totalCooperators += totalFitness;
                    coopCounter++;
                } else if (strat instanceof Strategy.randomlyCooperate) {
                    totalRandoms += totalFitness;
                    rndCounter++;
                } else if (strat instanceof Strategy.alwaysCheat) {
                    totalCheaters += totalFitness;
                    cheatCounter++;
                } else if (strat instanceof Strategy.tit4tat) {
                    totalTit4Tats += totalFitness;
                    t4tCounter++;
                }
            }

        }


    }
    public static void main (String[]args){
        AppPanel panel = new SimulationPanel(new PDFactory());
        panel.display();

    }
}
