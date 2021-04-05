package commands;
import java.util.HashMap;

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
    }
}
