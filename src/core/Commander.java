package core;
import commands.AbCommand;
import java.util.Arrays;
import java.util.HashMap;

public class Commander {
    private HashMap<String, AbCommand> cmds = new HashMap<>();

    /**
     * @param commands
     */
    public Commander(AbCommand... commands) {
        for(AbCommand cmd: commands) {
            this.cmds.put(cmd.getName(), cmd);
        }
    }

    /**
     * @param command
     */
    public void addCmd(AbCommand command) {
        this.cmds.put(command.getName(), command);
    }

    /**
     * @param command
     * @param consoler
     */
    public void sendCmd(String command, Consoler consoler) {
        command = command.trim();
        String[] preargs = command.split(" ", 2);
        if(preargs.length >= 2) preargs[1] = preargs[1].trim();
        String[] args = Arrays.copyOfRange(preargs, 1, command.split(" ").length);
        String cmd = command.split(" ")[0].trim();
        switch(cmd) {
            case "help":
                cmds.get(cmd).execute(this.cmds, args, consoler.getMode());
                break;
            default:
                try {
                    cmds.get(cmd).execute(args, consoler.getMode());
                } catch(Exception e) {
                    System.out.println("Unknown command. Type \"help\" to get the list of commands");
                }
                break;
        }
    }
}
