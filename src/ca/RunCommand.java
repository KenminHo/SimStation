package ca;
import mvc.*;


public class RunCommand extends Command {
    public RunCommand(Model model) {
        super(model);
    }

    public void execute() {
        if (model instanceof Grid) {
            ((Grid) model).updateLoop(1); // Assuming you want to advance the simulation by 1 cycle
        } else {
            System.out.println("Error: The provided model is not a Grid. The simulation cannot run.");
        }
    }
}
