package simstation;
import mvc.Model;
import mvc.Utilities;

import java.awt.*;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Iterator;
public class Simulation extends Model {

    protected ArrayList<Agent> agents = new ArrayList<>();
    protected int clock = 0;


    public void start() {
      //  System.out.println("Simulation start works");
        if(!agents.isEmpty())
        {
            agents.clear();
        }
        populate();
        for (Agent agent: agents) {
            Thread thread = new Thread(agent);
            thread.start();
        }
        startTimer();
    }

    public void stats() {

    }

    public void suspend() {
        for (Agent agent: agents) {
            agent.suspend();
        }
        stopTimer();

    }

    public void resume() {

        for (Agent agent: agents) {
            agent.resume();
        }
        startTimer();
    }

    public void stop() {
        for (Agent agent: agents) {
            agent.stop();
        }
        stopTimer();
    }

    public Agent getNeighbors(Agent a, double radius) {
        Agent hi = null;
        double x = 0;
        double y = 0;
        double distance = 0;
        int random = Utilities.rng.nextInt(agents.size()-1);
        for (Agent agent: agents) {
            if (agents.get(random) != a) {
                if (random == agents.size()-1) {
                    random = 0;
                    if(agents.get(random) == a)
                    {
                       random ++;
                    }
                }

                x = agents.get(random).xc - a.xc;
                y = agents.get(random).yx - a.yx;
                distance = Math.pow(x, 2) + Math.pow(y, 2);
                distance = Math.sqrt(distance);


                if (distance < radius) {
                     return agent;
                }
                random++;
            }
        }


        return hi;
    }

    public void populate() {}

    public void addAgent(Agent agent) {
        agents.add(agent);
        agent.setWorld(this);
    }

    transient private Timer timer; // timers aren't serializable


    private void startTimer() {
        timer = new Timer();
        timer.scheduleAtFixedRate(new ClockUpdater(), 1000, 1000);
    }

    private void stopTimer() {
        timer.cancel();
        timer.purge();
    }

    public Iterator<Agent> iterator() {
        System.out.println("REACHED here");
        return agents.iterator();
    }

    private class ClockUpdater extends TimerTask {
        public void run() {

            System.out.println("CLOCK WORKS)");
            clock++;
        }
    }
}
