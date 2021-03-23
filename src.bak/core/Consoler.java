package core;
import structure.Invoker;
import java.util.Scanner;

public class Consoler {
    private boolean active;
    private final Invoker invoker;

    public Consoler(Invoker invoker) {
        this.active = false;
        this.invoker = invoker;
    }

    public void start() {
        this.active = true;
        Scanner scanner = new Scanner(System.in);
        String cmd = scanner.nextLine();
        Commander commander = new Commander(this.invoker);
        commander.sendCmd(cmd, this);
        while(this.active) {
            cmd = scanner.nextLine();
            commander.sendCmd(cmd, this);
        }
    }

    public void stop() {
        this.active = false;
    }
}
