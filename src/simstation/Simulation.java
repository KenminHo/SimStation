package simstation;

import ca.Cell;
import mvc.Model;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public abstract class Simulation extends Model {

    protected ArrayList<Agent> agents = new ArrayList<>();
    private int clock = 0;




    public void start() {
        System.out.println("Simulation start works");
        populate();
        for (Agent agent: agents) {
            agent.start();
            System.out.println("there are agents");
        }
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
            ;System.out.println("Agents are Moving");
            hi = agent; 
        }
        
        return hi;
    }

    public abstract void populate();

    public void addAgent(Agent agent) {
        agents.add(agent);

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
            clock++;
        }
    }
}
