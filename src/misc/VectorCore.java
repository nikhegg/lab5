package misc;
import core.Globals;
import java.io.File;
import java.util.Date;
import java.util.Objects;
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
        System.out.println("\nAdded new route to the collection with ID " + route.getID());
    }

    public void updateID(int k, Route v) {
        this.vector.set(k ,v);
    }

    public void clear() {
        this.vector.clear();
    }

    public void removeElement(int id) {
        this.vector.remove(id);
    }

    public void loadCollection() {
        File csv = new File(Globals.envPath);
        if(csv.exists()) {
            if(csv.canRead()) {

            } else System.out.println("ERROR: Tried to load the collection from file, but it is not readable");
        }
    }

    public void saveToTheFile() {
        File csv = new File(Globals.envPath);
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VectorCore that = (VectorCore) o;
        return Objects.equals(vector, that.vector) && Objects.equals(creationDate, that.creationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vector, creationDate);
    }

    @Override
    public String toString() {
        return "VectorCore{" +
                "vector=" + vector +
                ", creationDate=" + creationDate +
                '}';
    }
}