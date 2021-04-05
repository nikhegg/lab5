package commands;
import exceptions.NotOverriddenException;
import java.util.HashMap;

public abstract class AbCommand implements Command {
    private final String name;
    private final String description;
    private final String usage;
    private final boolean hidden;

    public AbCommand(String name, String description, String usage, boolean hidden) {
        this.name = name;
        this.description = description;
        this.usage = usage;
        this.hidden = hidden;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public String getUsage() {
        return this.usage;
    }

    public boolean isHidden() {
        return hidden;
    }

    public void execute(String[] args) throws NotOverriddenException {
        throw new NotOverriddenException("Execute method of \"" + this.name + "\" command is not overridden");
    }

    public void execute(HashMap<String, AbCommand> map, String[] args) throws NotOverriddenException {
        throw new NotOverriddenException("Execute method of \"" + this.name + "\" commands is not overridden");
    }

}
