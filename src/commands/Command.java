package commands;

import exceptions.NotOverriddenException;

public interface Command {
    void execute(String[] args) throws NotOverriddenException;
}
