package core;
import commands.AbCommand;
import java.util.Arrays;
import java.util.HashMap;

public class Commander {
    private HashMap<String, AbCommand> cmds = new HashMap<>();

    public Commander(AbCommand... commands) {
        for(AbCommand cmd: commands) {
            this.cmds.put(cmd.getName(), cmd);
        }
    }

    public void addCmd(AbCommand command) {
        this.cmds.put(command.getName(), command);
    }

    public void sendCmd(String command, Consoler consoler) {
        String[] args = Arrays.copyOfRange(command.split(" "), 1, command.split(" ").length);
        String cmd = command.split(" ")[0];
        switch(cmd) {
            case "help" -> cmds.get(cmd).execute(this.cmds, args);
            default -> {
                try {
                    cmds.get(cmd).execute(args);
                } catch(Exception e) {
                    System.out.println("Unknown command. Type \"help\" to get the list of commands");
                }
            }
        }
    }
}
