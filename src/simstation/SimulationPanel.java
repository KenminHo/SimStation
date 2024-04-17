package simstation;

import mvc.AppFactory;
import mvc.AppPanel;
import mvc.Model;

import javax.swing.*;
import java.awt.*;
import java.util.Iterator;

public class SimulationPanel extends AppPanel{

    private JButton start;
    private JButton suspend;
    private JButton resume;
    private JButton stop;
    private JButton stats;

    transient protected Thread myThread;

    @Override
    public void setModel(Model m) {
        super.setModel(m); // calling AppPanel.setModel(m)
        Simulation s = (Simulation)m;
        Iterator<Agent> it = s.iterator();
        while(it.hasNext()) {
            Thread t = new Thread(it.next());
            t.start(); // this will call Agent.run (see below)
        }
    }
    public SimulationPanel(AppFactory factory) {
        super(factory);

        ControlPanel.setLayout(new GridLayout(5,2,10, 25));
        start = new JButton("Start");
        start.addActionListener(this);
        ControlPanel.add(start);
        suspend = new JButton("Suspend");
        suspend.addActionListener(this);
        ControlPanel.add(suspend);
        resume = new JButton("Resume");
        resume.addActionListener(this);
        ControlPanel.add(resume);
        stop = new JButton("Stop");
        stop.addActionListener(this);
        ControlPanel.add(stop);
        stats = new JButton("Stats");
        stats.addActionListener(this);
        ControlPanel.add(stats);
        this.display();
    }
}
