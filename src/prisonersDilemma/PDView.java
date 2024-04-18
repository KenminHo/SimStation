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

    @Override
    public void paintComponent(Graphics g) {

    }
}