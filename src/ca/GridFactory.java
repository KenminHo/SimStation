package ca;

import mvc.*;
import stopLight.ChangeCommand;

public abstract class GridFactory implements AppFactory {

    @Override
    public abstract Model makeModel();

    @Override
    public View makeView(Model m) {
        return new GridView((Grid)m);
    }

    @Override
    public abstract String getTitle();

    @Override
    public String[] getHelp() {
        return new String[] {"Creates a grid of clickable cells which different states"};
    }

    @Override
    public String about() {
        return "CA Model Version 1.0 ";
    }

    @Override
    public String[] getEditCommands() {
        return new String[] {"RUN1", "RUN50", "POPULATE", "CLEAR"};
    }

    @Override
    public Command makeEditCommand(Model model, String type, Object source) {
        if (type == "RUN1")
            return new RunCommand(model);
        else if (type == "RUN50")
            return new RunCommand50(model);
        else if (type == "POPULATE")
            return new PopulateCommand(model);
        else if (type == "CLEAR")
            return new ClearCommand(model);
        return null;
    }
}
