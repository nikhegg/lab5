package commands;
import java.util.HashMap;
// DONE
public class Help extends AbCommand {
    public Help(){
        super("help", "Shows all available commands", false);
    }

    public void execute(HashMap<String, AbCommand> map) {
        System.out.println("All commands:");
        map.forEach((k,v) -> {
            if(!v.isHidden()) {
                String msg = "• " + v.getName() + ": " + v.getDescription();
                System.out.println(msg);
            }
        });
        System.out.println("Type \"help <Command>\" to get usage of a command");
    }

    public void execute(String[] args) {

    }
}
