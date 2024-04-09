package stopLight;

import mvc.*;

public class ChangeCommand extends Command {

    public ChangeCommand(Model model) {
        super(model);
    }

    public void execute() {

        Stoplight light = (Stoplight)model;
        System.out.println("change command");
        light.change();
    }

}