package core;
import commands.AbCommand;

import java.util.Arrays;
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
        //TODO Getting args
        String[] args = Arrays.copyOfRange(command.split(" "), 1, command.split(" ").length);

        switch(command) {
            case "help" -> {
                
            }
            default -> {
                try {
                    cmds.get(command).execute(args);
                } catch(Exception e) {
                    System.out.println("Unknown command. Type \"help\" to get the list of commands  ");
                }
            }
        }
    }
}
