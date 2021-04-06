package misc;
import core.Globals;

public class Route {
    private long id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private java.time.ZonedDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private Location from; //Поле может быть null
    private Location to; //Поле может быть null
    private Double distance; //Поле может быть null, Значение поля должно быть больше 1

    public Route(String name, Coordinates coordinates, Location from, Location to, Double distance) {
        this.id = Globals.getRoutesCreated();
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = java.time.ZonedDateTime.now();
        this.from = from;
        this.to = to;
        this.distance = distance;
    }

    public void setID(long id) {
        this.id = id;
    }

    public long getID() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public Coordinates getCoordinates() {
        return this.coordinates;
    }

    public java.time.ZonedDateTime getCreationDate() {
        return this.creationDate;
    }

    public Location getStartLocation() {
        return this.from;
    }

    public Location getEndLocation() {
        return this.to;
    }

    public Double getDistance() {
        return this.distance;
    }
}
