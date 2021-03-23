package structure;

import core.NotOverridenException;

public interface Command {
    void execute(String[] args) throws NotOverridenException;
}
