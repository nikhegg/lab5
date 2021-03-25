package commands;

import exceptions.NotOverridenException;

public interface Command {
    void execute(String[] args) throws NotOverridenException;
}
