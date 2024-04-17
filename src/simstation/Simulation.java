package simstation;
import mvc.Model;
import mvc.Utilities;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class Simulation extends Model {

    protected ArrayList<Agent> agents = new ArrayList<>();
    protected int clock = 0;

    ClockUpdater temp = new ClockUpdater();

    public void start() {
      //  System.out.println("Simulation start works");
        populate();
        for (Agent agent: agents) {
            Thread thread = new Thread(agent);
            thread.start();
        }
        temp.run();
    }

    public void stats() {

    }

    public void suspend() {
        for (Agent agent: agents) {
            agent.suspend();
        }

    }

    public void resume() {
        for (Agent agent: agents) {
            agent.resume();
        }
    }

    public void stop() {
        for (Agent agent: agents) {
            agent.stop();
        }
    }

    public Agent getNeighbors(Agent a, int radius) {
        Agent hi = null;
        for (Agent agent: agents) {
            //System.out.println("Agents are Moving");
            hi = agent; 
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

    private class ClockUpdater extends TimerTask {
        public void run() {

            System.out.println("CLOCK WORKS)");
            clock++;
        }
    }
}
