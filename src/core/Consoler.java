package core;
import commands.ExecuteScript;
import commands.Exit;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Consoler {
    private boolean active;
    private final Commander commander;

    public Consoler(Commander commander) {
        this.active = false;
        this.commander = commander;
    }

    public void start() {
        try {
            System.out.println("| Lab5 Project by Nikita Kuldyshev\n" +
                    "| Version: " + Globals.version + "\n");
            this.active = true;
            this.commander.addCmd(new Exit(this));
            this.commander.addCmd(new ExecuteScript(this.commander, this));
            Scanner scanner = new Scanner(System.in);
            System.out.print("> ");
            String cmd = scanner.nextLine();
            this.commander.sendCmd(cmd, this);
            System.out.println();
            while(this.active) {
                System.out.print("> ");
                cmd = scanner.nextLine();
                this.commander.sendCmd(cmd, this);
                System.out.println();
            }
        } catch(NoSuchElementException e) {
            System.out.println("Чё???");
            System.exit(0);
        } catch (IllegalStateException e) {
            System.out.println("Чё");
        }

    }

    public void stop() {
        this.active = false;
    }
}
