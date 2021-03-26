package misc;
import java.io.File;
import java.util.Date;
import java.util.Vector;

public class VectorCore {
    private final Vector<Route> vector;
    private final Date creationDate;

    public VectorCore() {
        this.vector = new Vector<>();
        this.creationDate = new Date();
    }

    public int getSize() {
        return this.vector.size();
    }

    public Date getCreationDate() {
        return this.creationDate;
    }

    public void addElement(Route route) {
        this.vector.add(route);
        System.out.println("Added new route to the collection with ID " + (this.vector.size()-1));
        route.setID(this.vector.size()-1);
    }

    public void addElement() {

    }

    public void updateID() {

    }

    public void clear() {
        this.vector.clear();
    }

    public void removeElement(int id) {
        this.vector.remove(id);
    }

    public void loadCollection() {
        String filePath = System.getenv("VECTOR_COLLECTION_V");
        File csv = new File(filePath);
        if(csv.exists()) {
            if(csv.canRead()) {

            } else System.out.println("ERROR: Tried to load the collection from file, but it is not readable");
        }
    }

    public void saveToTheFile(String path) {
        File csv = new File(path);
        if(csv.exists()) {
            if(csv.canRead()) {
                if(csv.canWrite()) {

                } else System.out.println("ERROR: Unable to save the collection to the file. Missing write permissions");
            }
        }
    }

    public Vector<Route> getVector() {
        return this.vector;
    }

}