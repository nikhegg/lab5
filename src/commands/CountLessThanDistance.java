package commands;
import core.Globals;
import exceptions.NonIntStringException;
import misc.Route;
import misc.VectorCore;
// DONE
public class CountLessThanDistance extends AbCommand {
    private final VectorCore vector;

    public CountLessThanDistance(VectorCore vector) {
        super("count_less_than_distance", "Counts how many elements with distance that is lower than an entered value", "count_less_than_distance <distance>",false);
        this.vector = vector;
    }

    @Override
    public void execute(String[] args) {
        if(args.length <= 0) System.out.println("There is no value in the message");
        else if(!Globals.isInt(args[0])) System.out.println("Minimal value should be a number");
        else {
            try {
                int enteredValue = Globals.getInt(args[0]);
                if(enteredValue < 0) System.out.println("Distance cannot be negative");
                else {
                    int count = 0;
                    for (Route route : this.vector.getVector()) {
                        if(route.getDistance() < enteredValue) count += 1;
                    }
                    System.out.println("There are " + count + " elements in a collection with the distance lower than " + enteredValue);
                }
            } catch(NonIntStringException e) {
                System.out.println("Minimal value should be a number");
            } catch(Exception e) {
                System.out.println(e.getMessage());
            }
        }

    }
}
