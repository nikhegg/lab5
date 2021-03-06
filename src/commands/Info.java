package commands;
import core.ConsolerMode;
import misc.VectorCore;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Info extends AbCommand {
    private final VectorCore vector;

    /**
     * @param vector
     */
    public Info(VectorCore vector) {
        super("info", "Shows the information about collection (created at, size, etc.)", "info",false);
        this.vector = vector;
    }

    /**
     * @param args
     * @param mode
     */
    public void execute(String[] args, ConsolerMode mode) {
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        System.out.println("-----Collection info-----\nData Type: " + this.vector.getClass().getName() + "\nHash Code: " + this.vector.hashCode() + "\nInitialisation Date: " + df.format(this.vector.getCreationDate()) +
                "\nCollection Size: " + this.vector.getSize() + "\n-------------------------");
    }
}
