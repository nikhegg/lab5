package commands;
import exceptions.NotOverriddenException;
import java.util.HashMap;

public abstract class AbCommand implements Command {
    private final String name;
    private final String description;
    private final boolean hidden;

    public AbCommand(String name, String description, boolean hidden) {
        this.name = name;
        this.description = description;
        this.hidden = hidden;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public boolean isHidden() {
        return hidden;
    }

    public void execute(String[] args) throws NotOverriddenException {
        throw new NotOverriddenException("Execute method of \"" + this.name + "\" command is not overridden");
    }

    public void execute(HashMap<String, AbCommand> map) throws NotOverriddenException {
        throw new NotOverriddenException("Execute method of \"" + this.name + "\" commands is not overridden");
    }

}
