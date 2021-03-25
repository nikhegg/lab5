package core;
import commands.Exit;
import java.util.Scanner;

public class Consoler {
    private boolean active;
    private final Commander commander;

    public Consoler(Commander commander) {
        this.active = false;
        this.commander = commander;
    }

    public void start() {
        this.active = true;
        this.commander.addCmd(new Exit(this));
        Scanner scanner = new Scanner(System.in);
        String cmd = scanner.nextLine();
        this.commander.sendCmd(cmd, this);
        System.out.println();
        while(this.active) {
            cmd = scanner.nextLine();
            this.commander.sendCmd(cmd, this);
            System.out.println();
        }
    }

    public void stop() {
        this.active = false;
    }
}
