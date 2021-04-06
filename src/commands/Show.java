package commands;
import misc.Route;
import misc.VectorCore;

public class Show extends AbCommand {
    private final VectorCore vector;

    public Show(VectorCore vector) {
        super("show", "Shows current collection as a string", "show", false);
        this.vector = vector;
    }

    @Override
    public void execute(String[] args) {
        /*if(!vector.getCollection().equals("")) System.out.println(vector.getCollection());
        else System.out.println("The collection has no content inside");*/
        /*String message = "СID | Content\n";
        for(int i = 0; i<this.vector.getVector().size(); i++) {
            Route route = vector.getVector().get(i);
            message += i + " | Route " + route.getName() +
                    "\n\tID: " + route.getID() +
                    "\n\tCollectionID: " + i +
                    "\n\tCoordinates: (" + route.getCoordinates().getX() + ", " + route.getCoordinates().getY() + ")" +
                    "\n\tCreation date: " + route.getCreationDate().getDayOfMonth() + "/" + route.getCreationDate().getMonthValue() + "/" + route.getCreationDate().getYear() + " " + route.getCreationDate().getHour() + ":" + route.getCreationDate().getMinute();
            if(route.getStartLocation() == null) message += "\n\tStart location: No start location";
            else message += "\n\tStart location: " + route.getStartLocation().getName() + " (" + route.getStartLocation().getX() + ", " + route.getStartLocation().getY() + ", " + route.getStartLocation().getZ() + ")";
            if(route.getEndLocation() == null) message += "\n\tEnd location: No end location";
            else message += "\n\tEnd location: " + route.getEndLocation().getName() + " (" + route.getEndLocation().getX() + ", " + route.getEndLocation().getY() + ", " + route.getEndLocation().getZ() + ")";
            if(route.getDistance() == null) message += "\n\tDistance: Unknown";
            else message += "\n\tDistance: " + route.getDistance() + "\n";
        }
        if(message.equals("CID | Content\n")) System.out.println("The collection has 0 elements inside");
        else System.out.println("The collection has " + this.vector.getSize() + " elements inside\n" + message);*/
        String message = "";
        for(int i = 0; i<this.vector.getVector().size(); i++) {
            Route route = vector.getVector().get(i);
            /*message += "CID: " + i + " | Content:\n\t• " + route.getName() +
                    "\n\t• ID: " + route.getID() +
                    "\n\t• CollectionID: " + i +
                    "\n\t• Coordinates: (" + route.getCoordinates().getX() + ", " + route.getCoordinates().getY() + ")" +
                    "\n\t• Creation date: " + route.getCreationDate().getDayOfMonth() + "/" + route.getCreationDate().getMonthValue() + "/" + route.getCreationDate().getYear() + " " + route.getCreationDate().getHour() + ":" + route.getCreationDate().getMinute();
            if(route.getStartLocation() == null) message += "\n\t• Start location: No start location";
            else message += "\n\t• Start location: " + route.getStartLocation().getName() + " (" + route.getStartLocation().getX() + ", " + route.getStartLocation().getY() + ", " + route.getStartLocation().getZ() + ")";
            if(route.getEndLocation() == null) message += "\n\t• End location: No end location";
            else message += "\n\t• End location: " + route.getEndLocation().getName() + " (" + route.getEndLocation().getX() + ", " + route.getEndLocation().getY() + ", " + route.getEndLocation().getZ() + ")";
            if(route.getDistance() == null) message += "\n\t• Distance: Unknown\n\n";
            else message += "\n\t• Distance: " + route.getDistance() + "\n\n";*/
            message += this.vector.getElementInfo(route);
        }
        if(message.equals("")) System.out.println("The collection has 0 elements inside");
        else System.out.println("The collection has " + this.vector.getSize() + " elements inside\n" + message);
    }
}
