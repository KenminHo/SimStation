package ca;
import mvc.*;


public class PopulateCommand extends Command {
    public PopulateCommand(Model model) {
        super(model);
    }

    public void execute() {
        if (model instanceof Grid) {
            ((Grid) model).repopulate(true); //calling function from Grid class
        }
        else
        {
            System.out.println("Error: The provided model is not a Grid. It cannot populate. Try again");
        }
    }

}
