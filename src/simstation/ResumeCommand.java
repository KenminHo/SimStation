package simstation;

import mvc.Command;
import mvc.Model;

public class ResumeCommand extends Command {
    public ResumeCommand(Model model) {
        super(model);
    }

    @Override
    public void execute()
    {
        Simulation map = (Simulation)model;
        System.out.println("Resume command");
        map.resume();

    }
}
