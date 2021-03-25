package misc;
import exceptions.NullException;
import java.util.Scanner;

public class RouteMaker {

    public void throwError() {
        System.out.print("ERROR in RouteMaker");
    }

    public Route makeNewRoute() throws NullException { // TODO Check Route Maker
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nEnter the name of the new route: ");
        String name = scanner.nextLine();
        if(name == null) throw new NullException("The name of the route can't be a null");
        System.out.print("\nEnter coordinate X of the new route: ");
        long cordX = scanner.nextLong();
        System.out.print("\nEnter coordinate Y of the new route: ");
        Integer cordY = scanner.nextInt();
        if(cordY == null) throw new NullException("The coordinate Y of the route can't be a null");
        Coordinates cords = new Coordinates(cordX, cordY);
        // TODO DAFUQ?
        // java.time.ZonedDateTime date = scanner.next java.time.ZonedDateTime();
        System.out.print("\nIs there a start location of the route? \nType Y for \"yes\" or N for \"no\"");
        char locationExistence = scanner.next().charAt(0);
        Location locationOne = null;
        switch(locationExistence) {
            case 'Y' -> {
                System.out.print("\nEnter the name of the start location");
                String lname = scanner.nextLine();
                if(lname == null) throw new NullException("The name of the start location can't be a null");
                System.out.print("\nEnter coordinate X of the start location");
                Double lx = scanner.nextDouble();
                if(lx == null) throw new NullException("The coordinate X of the start location can't be a null");
                System.out.print("\nEnter coordinate Y of the start location");
                int ly = scanner.nextInt();
                System.out.print("\nEnter coordinate Z of the start location");
                Integer lz = scanner.nextInt();
                if(lz == null) throw new NullException("The coordinate Z of the start location can't be a null");
                locationOne = new Location(lname, lx, ly, lz);
            }
            case 'N' -> {
                System.out.print("\nThe route " + name + " doesn't have a start location");
                locationOne = null;
            }
            default -> {
                throwError();
            }
        }
        System.out.print("\nIs there an end location of the route? \nType Y for \"yes\" or N for \"no\"");
        locationExistence = scanner.next().charAt(0);
        Location locationTwo = null;
        switch(locationExistence) {
            case 'Y' -> {
                System.out.print("\nEnter the name of the end location");
                String lname = scanner.nextLine();
                if(lname == null) throw new NullException("The name of the end location can't be a null");
                System.out.print("\nEnter coordinate X of the end location");
                Double lx = scanner.nextDouble();
                if(lx == null) throw new NullException("The coordinate X of the end location can't be a null");
                System.out.print("\nEnter coordinate Y of the end location");
                int ly = scanner.nextInt();
                System.out.print("\nEnter coordinate Z of the end location");
                Integer lz = scanner.nextInt();
                if(lz == null) throw new NullException("The coordinate Z of the end location can't be a null");
                locationTwo = new Location(lname, lx, ly, lz);
            }
            case 'N' -> {
                System.out.print("\nThe route " + name + " doesn't have an end location");
                locationTwo = null;
            }
            default -> {
                throwError();
            }
        }
        return new Route(name, cords, locationOne, locationTwo, 1.0);// TODO Not all parameters are given to Route
    }
}
