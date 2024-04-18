package prisonersDilemma;
import simstation.*;
import mvc.*;

//----------------------------------------------------------------

public interface Strategy {
    boolean decision(Prisoner p);

    String assignStrat();


    class alwaysCooperate implements Strategy {
        @Override public boolean decision(Prisoner p) {return true;}
         @Override public String assignStrat() {return "Cooperate";}
    }

    class randomlyCooperate implements Strategy {
        @Override public boolean decision(Prisoner p) {return Math.random() < 0.5;}
        @Override public String assignStrat() {return "Randomly Cooperate";}
    }

    class alwaysCheat implements Strategy {
        @Override public boolean decision(Prisoner p) {return false;}
        @Override public String assignStrat() {return "Cheat";}
    }

    class tit4tat implements Strategy {
        @Override public boolean decision(Prisoner p) {
            if (p.didTheyCheat()) return false;
            else return true;
        }
        @Override public String assignStrat() {return "Tit4Tat";}
    }
}
