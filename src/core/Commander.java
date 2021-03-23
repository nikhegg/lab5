package core;
import commands.AbCommand;
import java.util.HashMap;

public class Commander {
    private HashMap<String, AbCommand> cmds = new HashMap<String, AbCommand>();

    public Commander(AbCommand... commands) {
        for(AbCommand cmd: commands) {
            this.cmds.put(cmd.getName(), cmd);
        }
    }

    public void addCmd(AbCommand command) {
        this.cmds.put(command.getName(), command);
    }

    public void sendCmd(String command, Consoler consoler) {
        switch(command) {
            case "help" -> {
                
            }
            default -> {
                try {
                    cmds.get(command).execute();
                } catch(Exception e) {
                    System.out.println("Unknown command. Type \"help\" to get the list of commands  ");
                }
            }
        }
    }
}
