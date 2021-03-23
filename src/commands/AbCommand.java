package commands;

import structure.Command;
import core.NotOverridenException;

public class AbCommand implements Command {
    private final String name;
    private final String description;

    public AbCommand(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public void execute() throws NotOverridenException {
        throw new NotOverridenException("Execute method of \"" + this.name + "\" command is not overriden");
    }

    public void undo() throws NotOverridenException {
        throw new NotOverridenException("Undo method of \"" + this.name + "\" command is not overriden");
    }
}
