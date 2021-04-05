package commands;
import misc.Route;
import misc.VectorCore;

public class Show extends AbCommand {
    private final VectorCore vector;

    public Show(VectorCore vector) {
        super("show", "Shows current collection as a string", false);
        this.vector = vector;
    }

    @Override
    public void execute(String[] args) {
        /*if(!vector.getCollection().equals("")) System.out.println(vector.getCollection());
        else System.out.println("The collection has no content inside");*/
        String message = "ID | Content\n";
        for(int i = 0; i<this.vector.getVector().size(); i++) {
            Route route = vector.getVector().get(i);
            message += route.getID() + " | Route " + route.getName() +
                    "\n\tID: " + route.getID() +
                    "\n\tCoordinates: (" + route.getCoordinates().getX() + ", " + route.getCoordinates().getY() + ")" +
                    "\n\tStart location: " + route.getStartLocation().getName() + " (" + route.getStartLocation().getX() + ", " + route.getStartLocation().getY() + ", " + route.getStartLocation().getZ() + ")" +
                    "\n\tEnd location: " + route.getEndLocation().getName() + " (" + route.getEndLocation().getX() + ", " + route.getEndLocation().getY() + ", " + route.getEndLocation().getZ() + ")" +
                    "\n\tDistance: " + route.getDistance() + "\n";
        }
        if(message.equals("ID | Content\n")) System.out.println("The collection has 0 elements inside");
        else System.out.println("The collection has " + this.vector.getSize() + " elements inside\n" + message);
    }
}
