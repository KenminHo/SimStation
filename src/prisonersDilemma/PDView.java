package prisonersDilemma;
import mvc.*;
import simstation.*;
import java.awt.*;
import javax.swing.*;
import java.util.*;

public class PDView extends SimulationView {
    private Color alwaysCoopColor = Color.green;
    private Color randCoopColor = Color.cyan;
    private Color titForTatColor = Color.orange;
    private Color alwaysCheatColor = Color.red;

    //-----------------------------------------

    public PDView(Model m) {
        super(m);
        setBackground(Color.black);
    }

    @Override public void paintComponent(Graphics g) {
        super.paintComponent(g);
        PDSimulation pd = (PDSimulation) model;
        ArrayList<Agent> agents = pd.getAgents();
        for (Agent a : agents) {
            if (a instanceof Cooperate) {
                g.setColor(Color.BLUE);
            } else {
                g.setColor(Color.RED);
            }
            g.fillOval(a.getX(), a.getY(), 5, 5);
        }
    }
}
