package core;

import java.util.Date;
import java.util.Vector;

public class VectorCore {
    private final Vector vector;
    private final Date creationDate;

    public VectorCore() {
        this.vector = new Vector();
        this.creationDate = new Date();
    }

    public int getSize() {
        return this.vector.size();
    }

    public Date getCreationDate() {
        return this.creationDate;
    }

    public String getCollection() {
        String collectionLines = "";
        for(int i = 0; i<this.vector.size(); i++) {
            collectionLines += (i+1) + ". " + vector.get(i) + "\n";
        }
        return collectionLines;
    }

    public void addElement(String line) {
        this.vector.add(line);
    }

    public void addElement() {

    }

    public void updateID() {

    }

    public void clear() {
        this.vector.clear();
    }

    public void removeElement() {

    }

    public Vector getVector() {
        return this.vector;
    }

}