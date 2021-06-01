package commands;
import core.Consoler;
import core.ConsolerMode;
import exceptions.NotOverriddenException;
import java.util.HashMap;

public abstract class AbCommand implements Command {
    private final String name;
    private final String description;
    private final String usage;
    private final boolean hidden;

    /**
     * @param name
     * @param description
     * @param usage
     * @param hidden
     */
    public AbCommand(String name, String description, String usage, boolean hidden) {
        this.name = name;
        this.description = description;
        this.usage = usage;
        this.hidden = hidden;
    }

    /**
     * @return
     */
    public String getName() {
        return this.name;
    }

    /**
     * @return
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * @return
     */
    public String getUsage() {
        return this.usage;
    }

    /**
     * @return
     */
    public boolean isHidden() {
        return hidden;
    }

    /**
     * @param args
     * @param mode
     * @throws NotOverriddenException
     */
    public void execute(String[] args, ConsolerMode mode) throws NotOverriddenException {
        throw new NotOverriddenException("Execute method of \"" + this.name + "\" command is not overridden");
    }

    /**
     * @param map
     * @param args
     * @param mode
     * @throws NotOverriddenException
     */
    public void execute(HashMap<String, AbCommand> map, String[] args, ConsolerMode mode) throws NotOverriddenException {
        throw new NotOverriddenException("Execute method of \"" + this.name + "\" commands is not overridden");
    }

}
