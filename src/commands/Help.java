package commands;
import java.util.HashMap;

public class Help extends AbCommand {
    public Help(){
        super("help", "Shows all available commands");
    }

    public void showCommands(HashMap<String, AbCommand> map) {

    }
}
