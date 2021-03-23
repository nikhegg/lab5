package structure;

import core.NotOverridenException;

public interface Command {
    void execute() throws NotOverridenException;
    void undo() throws NotOverridenException;  //TODO Remove this shit please
}
