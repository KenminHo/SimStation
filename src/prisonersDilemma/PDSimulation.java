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
        return Color.BLACK;
    }

    @Override
    public void populate() {

        int tracker = 0;
        for (int i = 0; i < 40; i++) {

            Color current = Color.WHITE;

            Color s = switch (i % 4) {
                case 0 -> current = Color.green;

                case 1 -> current = Color.cyan;

                case 2 -> current = Color.orange;

                case 3 -> current = Color.red;

                default -> throw new IllegalStateException("Unexpected value: " + i % 4);
            };

            addAgent(new Prisoner("P# " + i, current));
        }
    }

        public void stats() {
            int cheatCounter = 0;
            int coopCounter = 0;
            int rndCounter = 0;
            int t4tCounter = 0;

            for (Agent agent : agents) {
                Prisoner p = (Prisoner) agent;
                if (p.color == Color.green) {
                    coopCounter += p.fitness;
                } else if (p.color == Color.cyan) {
                    rndCounter += p.fitness;
                } else if (p.color == Color.orange) {
                    t4tCounter += p.fitness;
                } else if (p.color == Color.red) {
                    cheatCounter += p.fitness;
                }
            }

            Utilities.inform(new String[]{"CoopStrat = " + coopCounter, "RandomStrat = " + rndCounter, "Tit4TatStrat = " + t4tCounter, "CheatStrat = " + cheatCounter});
        }

        public static void main (String[]args){
            AppPanel panel = new SimulationPanel(new PDFactory());
            Simulation world = new Simulation();
            world.populate();
            panel.display();

        }

    }
