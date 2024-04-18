package prisonersDilemma;
import simstation.*;
import mvc.*;
import java.util.*;

public class PDSimulation extends Simulation {
    @Override
    public void populate() {

        //Generate prisoners
        //Strategies equally divided b/w prisoners
        for (int i = 0; i < 40; i++) {

/*            Strategy s;
            if (i % 4 == 0) {
                this.addAgent("P# " + i, new s.alwaysCooperate());
            } else if (i % 4 == 1) {
                this.addAgent("P# " + i, s.randomlyCooperate());
            } else if (i % 4 == 2) {
                addAgent(new Prisoner("P# " + i, new alwatsCheat()));
            } else {
                addAgent(new Prisoner("P# " + i, new tit4tat()));
            }*/

            Strategy s = switch (i % 4) {
                case 0 -> new Strategy.alwaysCooperate();
                case 1 -> new Strategy.randomlyCooperate();
                case 2 -> new Strategy.alwaysCheat();
                case 3 -> new Strategy.tit4tat();
                default -> null;
            };
            addAgent(new Prisoner("P# " + i, s));
        }
    }

    public String getStats() {
        int totalFitness = 0;

        int totalCheaters = 0;
        int totalCooperators = 0;
        int totalRandoms = 0;
        int totalTit4Tats = 0;

        int cheatCounter = 0;
        int coopCounter = 0;
        int rndCounter = 0;
        int t4tCounter = 0;

            /*for (Agent a : agents) {
                Prisoner p = (Prisoner) a;
                totalFitness += p.getFit();
                if (p.didTheyCheat()) totalCheaters++;
            }
            return "Average Fitness: " + totalFitness / agents.size() + "\n" +
                    "Total Cheaters: " + totalCheaters;*/

        Iterator<Agent> itr = agents.iterator();
        while (itr.hasNext()) {
            Agent aa = itr.next();
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

/*                if (p.didTheyCheat()) totalCheaters++;
                if (p.getStrat().assignStrat().equals("Cooperate")) totalCooperators++;
                if (p.getStrat().assignStrat().equals("Randomly Cooperate")) totalRandoms++;
                if (p.getStrat().assignStrat().equals("Tit4Tat")) totalTit4Tats++;*/
        }
        return "Average Fitness Numbers For: " +
                "\nAlways Cooperative - " + (totalCooperators / coopCounter) +
                "\nRandomly Cooperative - " + (totalRandoms / rndCounter) +
                "\nAlways Cheating - " + (totalCheaters / cheatCounter) +
                "\nTit4Tat - " + (totalTit4Tats / t4tCounter);

/*            Prisoner p = (Prisoner) itr.next();
            totalFitness += p.getFit();
            if (p.didTheyCheat()) totalCheaters++;
            if (p.getStrat().assignStrat().equals("Cooperate")) totalCooperators++;
            if (p.getStrat().assignStrat().equals("Randomly Cooperate")) totalRandoms++;
            if (p.getStrat().assignStrat().equals("Tit4Tat")) totalTit4Tats++;*/
        //}
/*        return "Average Fitness: " + totalFitness / agents.size() + "\n" +
                "Total Cheaters: " + totalCheaters + "\n" +
                "Total Cooperators: " + totalCooperators + "\n" +
                "Total Randomly Cooperate: " + totalRandoms + "\n" +
                "Total Tit4Tat: " + totalTit4Tats;*/
    }
}
