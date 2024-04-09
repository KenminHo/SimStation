package simstation;

import mvc.Command;
import mvc.Model;

public class StopCommand extends Command {
    public StopCommand(Model model) {
        super(model);
    }

    @Override
    public void execute() {
        Simulation map = (Simulation)model;
        System.out.println("Stop command");
        map.stop();

    }
}
