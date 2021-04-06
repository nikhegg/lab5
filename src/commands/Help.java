package commands;
import java.util.HashMap;

public class Help extends AbCommand {
    public Help(){
        super("help", "Shows all available commands", "help <nothing or command>", false);
    }

    public void execute(HashMap<String, AbCommand> map, String[] args) {
        if(args.length == 0 || map.get(args[0]) == null) {
            System.out.println("All commands:");
            map.forEach((k,v) -> {
                if(!v.isHidden()) {
                    String msg = "• " + v.getName() + ": " + v.getDescription();
                    System.out.println(msg);
                }
            });
            System.out.println("Type \"help <Command>\" to get usage of a command");
        } else {
            System.out.println("Command name: " + map.get(args[0]).getName() + "\nDescription: " + map.get(args[0]).getDescription() + "\nUsage: " + map.get(args[0]).getUsage() + "\nHidden: " + (map.get(args[0]).isHidden() ? "Yes" : "No"));
        }
       
    }
}
