package misc;

public class Location {
    private Double x; //Поле не может быть null
    private int y;
    private Integer z; //Поле не может быть null
    private String name; //Поле может быть null

    Location(String name, Double x, int y, Integer z) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.z = z;
    }
}
