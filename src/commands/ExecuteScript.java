package commands;
import core.Commander;
import core.Consoler;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ExecuteScript extends AbCommand {
    private Commander commander;
    private Consoler consoler;

    public ExecuteScript(Commander commander, Consoler consoler) {
        super("execute_script", "Executes the script from a specified file", "execute_script <path>",false);
        this.commander = commander;
        this.consoler = consoler;
    }

    @Override
    public void execute(String[] args) { // TODO Is it working good?
        try {
            File file = new File(args[0]);
            Scanner fsc = new Scanner(file);
            while(fsc.hasNextLine()) {
                String msg = fsc.nextLine();
                System.out.println("> " + msg);
                commander.sendCmd(msg, this.consoler);
            }
        } catch(FileNotFoundException e) {
            System.out.println("Файла не существует");
        }
    }
}
