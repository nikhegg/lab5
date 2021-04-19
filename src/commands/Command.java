package commands;

import core.ConsolerMode;
import exceptions.NotOverriddenException;

public interface Command {
    void execute(String[] args, ConsolerMode mode) throws NotOverriddenException;
}
