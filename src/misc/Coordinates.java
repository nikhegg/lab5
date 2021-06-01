package misc;

public class Coordinates {
    private long x;
    private Integer y; //Поле не может быть null

    /**
     * @param x
     * @param y
     */
    public Coordinates(long x, Integer y) {
        this.x = x;
        this.y = y;
    }

    /**
     * @return
     */
    public long getX() {
        return this.x;
    }

    /**
     * @return
     */
    public long getY() {
        return this.y;
    }
}
