package core;
import commands.ExecuteScript;
import commands.Exit;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Consoler {
    private boolean active;
    private final Commander commander;
    private static Scanner commandReader = new Scanner(System.in);
    private ConsolerMode mode;

    public Consoler(Commander commander) {
        this.active = false;
        this.commander = commander;
        this.mode = ConsolerMode.USER;
    }

    public void start() {
        try {
            System.out.println("| Lab5 Project by Nikita Kuldyshev\n" +
                    "| Version: " + Globals.getVersion() + "\n");
            this.active = true;
            this.commander.addCmd(new Exit(this));
            this.commander.addCmd(new ExecuteScript(this));
            System.out.print("> ");
            String cmd = commandReader.nextLine();
            this.commander.sendCmd(cmd, this);
            System.out.println();
            while(this.active) {
                System.out.print("> ");
                cmd = commandReader.nextLine();
                if(this.mode == ConsolerMode.USER) this.commander.sendCmd(cmd , this);
            }
        } catch(NoSuchElementException e) {
            System.out.println("Чё???");
            System.exit(0);
        } catch (IllegalStateException e) {
            System.out.println("Чё");
        }

    }

    public boolean doScript(Scanner scannedScript) {
        setMode(ConsolerMode.SCRIPT);
        declareNewScanner(scannedScript);
        String cmd = commandReader.nextLine();
        System.out.println("> " + cmd);
        this.commander.sendCmd(cmd, this);
        while(this.active && scannedScript.hasNextLine()) {
            cmd = commandReader.nextLine();
            System.out.println("> " + cmd);
            this.commander.sendCmd(cmd, this);
            try {
                TimeUnit.MILLISECONDS.sleep(500);
            } catch(InterruptedException e) {
                return false;
            }
        }
        restoreScanner();
        setMode(ConsolerMode.USER);
        return true;
    }

    public void stop() {
        this.active = false;
    }

    public void declareNewScanner(Scanner scanner) {
        commandReader = scanner;
    }

    public void restoreScanner() {
        commandReader = new Scanner(System.in);
    }

    public void setMode(ConsolerMode mode) {
        this.mode = mode;
    }

    public static Scanner getScanner() {
        return commandReader;
    }

    public ConsolerMode getMode() {
        return this.mode;
    }

}
