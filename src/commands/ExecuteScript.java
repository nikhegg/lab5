package commands;
import core.Consoler;
import core.ConsolerMode;
import exceptions.RecursionException;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;

public class ExecuteScript extends AbCommand {
    private final Consoler consoler;
    Vector<String> usedScripts = new Vector<>();
    private String currentFile = null;

    public ExecuteScript(Consoler consoler) {
        super("execute_script", "Executes the script from a specified file", "execute_script <path>",false);
        this.consoler = consoler;
    }

    @Override
    public void execute(String[] args, ConsolerMode mode) {
        try {
            if(mode == ConsolerMode.USER) usedScripts.clear();
            if(usedScripts.contains(args[0])) throw new RecursionException("Script execution stopped - recursion found");
            else {
                usedScripts.add(args[0]);
                if(currentFile == null) currentFile = args[0];
            }
            File file = new File(args[0]);
            Scanner fsc = new Scanner(file);
            boolean done = this.consoler.doScript(fsc);
            if(done && currentFile.equals(args[0])) System.out.println("\nScript from file " + args[0] + " was successfully executed");
            currentFile = null;
        } catch(FileNotFoundException e) {
            System.out.println("File does not exist");
        } catch(RecursionException e) {
            System.out.println(e.getMessage());
        }
        this.consoler.setMode(ConsolerMode.USER);
        this.consoler.restoreScanner();
    }
}