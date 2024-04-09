package ca;
import mvc.*;


public class RunCommand50 extends Command {
    public RunCommand50(Model model) {
        super(model);
    }

    public void execute() {
        if (model instanceof Grid) {
            ((Grid) model).updateLoop(50); // Assuming you want to advance the simulation by 50 cycle
        } else {
            System.out.println("Error: The provided model is not a Grid. Cannot run simulation.");
        }
    }
}
