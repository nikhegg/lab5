package core;
import structure.Invoker;

public class Commander {
    private final Invoker invoker;

    public Commander(Invoker invoker) {
        this.invoker = invoker;
    }

    public void sendCmd(String command, Consoler consoler) {
        switch(command) {
            case "info" -> invoker.turnOn();
            case "exit" -> {
                System.out.println("Shutting down the program...");
                consoler.stop();
            }
            default -> System.out.println("Unknown command. Type \"help\" to get the list of commands");
        }
    }
}
