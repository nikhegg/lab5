package core;
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
                    "| Version: 1.8\n");
            this.active = true;
            this.commander.addCmd(new Exit(this));
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
            System.out.println("Дрисня какая-то, я ливаю");
            System.exit(0);
        } catch (IllegalStateException e) {
            System.out.println("Непредвиденная ошибка!");
        }

    }

    public void stop() {
        this.active = false;
    }
}
