package commands;
import core.ConsolerMode;
import misc.Route;
import misc.VectorCore;

public class Show extends AbCommand {
    private final VectorCore vector;

    /**
     * @param vector
     */
    public Show(VectorCore vector) {
        super("show", "Shows current collection as a string", "show", false);
        this.vector = vector;
    }

    /**
     * @param args
     * @param mode
     */
    @Override
    public void execute(String[] args, ConsolerMode mode) {
        String message = "";
        for(int i = 0; i<this.vector.getVector().size(); i++) {
            Route route = vector.getVector().get(i);
            message += this.vector.getElementInfo(route);
        }
        if(message.equals("")) System.out.println("The collection has 0 elements inside");
        else System.out.println("The collection has " + this.vector.getSize() + " elements inside\n" + message);
    }
}
