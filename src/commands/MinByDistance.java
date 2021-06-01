package commands;
import core.ConsolerMode;
import misc.Route;
import misc.VectorCore;
import java.util.Vector;

public class MinByDistance extends AbCommand {
    private final VectorCore vector;

    /**
     * @param vector
     */
    public MinByDistance(VectorCore vector) {
        super("min_by_distance", "Finds one of elements in the collection which has the less distance parameter", "min_by_distance", false);
        this.vector = vector;
    }

    /**
     * @param args
     * @param mode
     */
    @Override
    public void execute(String[] args, ConsolerMode mode) {
        if(this.vector.getSize() <= 0) System.out.println("The collection is empty");
        else {
            Double distance = null;
            for (Route route : this.vector.getVector()) if(route.getDistance() != null && (distance == null || route.getDistance() < distance)) distance = route.getDistance();
            if(distance != null) {
                Vector<Route> smallestRoutes = new Vector<>();
                for (Route route : this.vector.getVector()) {
                    if(route.getDistance() != null && route.getDistance().equals(distance)) {
                        smallestRoutes.add(route);
                    }
                }
                if(smallestRoutes.size() > 0) {
                    int random = (int) Math.floor(Math.random()*smallestRoutes.size());
                    Route chosenRoute = smallestRoutes.get(random);
                    System.out.println(this.vector.getElementInfo(chosenRoute));
                } else System.out.println("All elements of collection has no distance parameter");
            } else System.out.println("All elements of the collection has no distance parameter");

        }
    }
}
