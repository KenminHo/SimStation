package ca;
import mvc.*;


public class ClearCommand extends Command {
    public ClearCommand(Model model) {
        super(model);
    }

    public void execute() {
        if (model instanceof Grid) {
            ((Grid) model).repopulate(false); //calling function from Grid class
        }
        else
        {
            System.out.println("Error: The provided model is not a Grid. It cannot populate. Try again");
        }

    }

}
