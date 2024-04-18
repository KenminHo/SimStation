package simstation;

import mvc.*;
import stopLight.ChangeCommand;

public abstract class SimulationFactory implements AppFactory {
    @Override
    public abstract Model makeModel();

    @Override
    public View makeView(Model m) {
        return new SimulationView(m);
    }

    @Override
    public String[] getEditCommands() {
        return new String[]{"Start", "Suspend", "Resume", "Stop", "Stats"};
    }

    @Override
    public Command makeEditCommand(Model model, String type, Object source) {
        return switch (type) {
            case "Start" -> new StartCommand(model);
            case "Suspend" -> new SuspendCommand(model);
            case "Resume" -> new ResumeCommand(model);
            case "Stop" -> new StopCommand(model);
            case "Stats" -> new StatsCommand(model);
            default -> null;
        };
    }
    @Override public String[] getHelp() { return new String[] {"[Start] to begin a simulation",
            "[Suspend] to pause the simulation",
    "[Resume] to resume paused simulation",
    "[Stop] to end simulation",
    "[Stats] to view simulation details"}; }
    @Override public String about() { return "Flocking Simulation " +
            "\n CS151 Group 11 \n Kenmin Ho, Taras Tishchenko";
    }

}
