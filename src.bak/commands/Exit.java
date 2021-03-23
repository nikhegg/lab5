package commands;
import core.Consoler;

public class Exit extends AbCommand {
    private final Consoler consoler;

    public Exit(Consoler consoler) {
        super("exit", "Stops the program");
        this.consoler = consoler;
    }

    public void execute() {
        this.consoler.stop();
    }

    public void undo() {
        this.consoler.start();
    }
}
