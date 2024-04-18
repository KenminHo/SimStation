package prisonersDilemma;
import simstation.*;
import mvc.*;

import java.awt.*;

public class Prisoner extends Agent {
    protected int fitness = 0;
    private boolean partnerCheated = false;

    protected Color color = Color.BLACK;


    //-----------------------


    public Prisoner (String name, Color color) {
        super();
        this.heading = Heading.random();
        this.color = color;
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

    public boolean didTheyCheat() {return partnerCheated;}


    public Color getColor() {
        return this.color;
    }

    public void update() {
        Prisoner partner = (Prisoner)world.getNeighbors(this, 10);
        heading = Heading.random();
        int steps = Utilities.rng.nextInt(10) + 1;
        boolean one = false;
        boolean two = false;

        if(partner != null) {

            if (this.color == Color.green) {
                one = true;
            } else if (this.color == Color.red) {
                one = false;
            } else if (this.color == Color.cyan) {
                int random = 0;
                random = Utilities.rng.nextInt(2);
                if (random == 0) {
                    one = true;
                } else if (random == 1) {
                    one = false;
                }
            } else if (this.color == Color.orange) {
                if (partnerCheated) {
                    one = false;
                }
            }


            if (partner.color == Color.green) {
                two = true;
            } else if (partner.color == Color.red) {
                two = false;
            } else if (partner.color == Color.cyan) {
                int random = 0;
                random = Utilities.rng.nextInt(2);
                if (random == 0) {
                    two = true;
                } else if (random == 1) {
                    two = false;
                }
            } else if (partner.color == Color.orange) {
                if (partnerCheated) {
                    two = false;
                }
            }

            if (two) {
                partnerCheated = true;
            }

            fitnessScores(one, two);
        }
        move(steps);
    }
}