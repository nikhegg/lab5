package commands;
import core.ConsolerMode;
import misc.VectorCore;

public class RemoveLast extends AbCommand {
    private final VectorCore vector;

    public RemoveLast(VectorCore vector) {
        super("remove_last", "Removes the last element of the collection", "remove_last", false);
        this.vector = vector;
    }

    @Override
    public void execute(String[] args, ConsolerMode mode) {
        if(this.vector.getSize() >= 1) {
            this.vector.removeElement(this.vector.getSize()-1);
            System.out.println("The last element of the collection was successfully removed");
        }
        else System.out.println("Cannot remove the last element of the collection because the collection is empty");
    }
}
