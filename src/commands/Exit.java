package commands;
import core.Consoler;
import core.ConsolerMode;

public class Exit extends AbCommand {
    private final Consoler consoler;

    public Exit(Consoler consoler) {
        super("exit", "Stops the program", "exit",false);
        this.consoler = consoler;
    }

    public void execute(String[] args, ConsolerMode mode) {
        System.out.println("Shutting down the program...");
        this.consoler.stop();
    }
}
