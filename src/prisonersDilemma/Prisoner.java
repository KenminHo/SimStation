package prisonersDilemma;
import simstation.*;
import mvc.*;

import java.awt.*;

public class Prisoner extends Agent {
    private int fitness = 0;
    private boolean partnerCheated = false;
    private Strategy strat;

    //-----------------------

    public boolean cooperate() {
        return true;
        //return strategy.decide(this);
    }

    public Prisoner (String name, Strategy strat) {
        super();
        this.heading = Heading.random();
        this.strat = strat;
    }

    public void fitnessScores (boolean pa, boolean pb) {
        //prisoner a cooperates, prisoner b cheats
        if (pa && !pb) fitness += 0;
            //prisoner a cheats, prisoner b cooperates
        else if (!pa && pb) fitness += 5;
            //both prisoners cooperate
        else if (pa && pb) fitness += 3;
            //both prisoners cheat
        else if (!pa && !pb) fitness += 1;
    }

    public Strategy getStrat() {return strat;}
    public int getFit() {return fitness;}
    public boolean didTheyCheat() {return partnerCheated;}

    @Override
    public Color getColor() {
        return Color.WHITE;
    }

    @Override public void update() {
        Prisoner partner = (Prisoner)world.getNeighbors(this, 10);
        heading = Heading.random();
        if (partner != null) {
//            partnerCheated = partner.cooperate();
//            fitnessScores(strat.cooperate(), partnerCheated);
            boolean aStrat = cooperate();
            boolean bStrat = partner.cooperate();
            fitnessScores(aStrat, bStrat);
            partner.fitnessScores(bStrat, aStrat);
            partnerCheated = !bStrat;
            partner.partnerCheated = !aStrat;
        }
        move(2);
    }
}