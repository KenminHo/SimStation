package simstation;

import ca.Grid;
import mvc.Command;
import mvc.Model;
import stopLight.Stoplight;

public class StartCommand extends Command {
    public StartCommand(Model model) {
        super(model);
    }

    @Override
    public void execute() {
        Simulation map = (Simulation)model;
        System.out.println("Start command");
        map.start();
    }

}
