package misc;

public class Location {
    private Double x; //Поле не может быть null
    private int y;
    private Integer z; //Поле не может быть null
    private String name; //Поле может быть null

    public Location(String name, Double x, int y, Integer z) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public String getName() {
        return this.name;
    }

    public Double getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public Integer getZ() {
        return this.z;
    }
}
