package core;
import exceptions.IncorrectArgumentException;
import exceptions.NonIntStringException;
import exceptions.NullException;
import misc.Coordinates;
import misc.Location;
import misc.Route;
import java.util.Scanner;

public class Globals {
    public static double version = 1.9;
    public static String envPath = System.getenv("VECTOR_COLLECTION_V");
    public static long routesCreated = 0;

    public static Route makeNewRoute() throws NullException, IncorrectArgumentException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the name of the new route: ");
        String name = scanner.nextLine();
        if(name == null) throw new NullException("The name of the route can't be a null");
        System.out.print("Enter coordinate X of the new route: ");
        long cordX = scanner.nextLong();
        System.out.print("Enter coordinate Y of the new route: ");
        Integer cordY = scanner.nextInt();
        Coordinates cords = new Coordinates(cordX, cordY);
        System.out.print("\nIs there a start location of the route? \nType Y for \"yes\" or N for \"no\": ");
        String locationName;
        char locationExistence = scanner.next().trim().charAt(0);
        Location locationOne = null;
        switch(locationExistence) {
            case 'Y', 'y' -> {
                System.out.print("\nEnter the name of the start location: ");
                locationName = scanner.nextLine();
                locationName = scanner.nextLine();
                if(locationName == null) throw new NullException("The name of the start location can't be a null");
                System.out.print("Enter coordinate X of the start location: ");
                Double lx = scanner.nextDouble();
                    //if(lx == null) throw new NullException("The coordinate X of the start location can't be a null");
                System.out.print("Enter coordinate Y of the start location: ");
                int ly = scanner.nextInt();
                System.out.print("Enter coordinate Z of the start location: ");
                Integer lz = scanner.nextInt();
                    //if(lz == null) throw new NullException("The coordinate Z of the start location can't be a null");
                locationOne = new Location(locationName, lx, ly, lz);
            }
            case 'N', 'n' -> System.out.print("\nThe route " + name + " doesn't have a start location\n");
            default -> throw new IncorrectArgumentException("Should get Y/N, got " + locationExistence);
        }
        System.out.print("\nIs there an end location of the route? \nType Y for \"yes\" or N for \"no\": ");
        locationExistence = scanner.next().charAt(0);
        Location locationTwo = null;
        switch(locationExistence) {
            case 'Y', 'y' -> {
                System.out.print("\nEnter the name of the end location: ");
                locationName = scanner.nextLine();
                locationName = scanner.nextLine();
                if(locationName == null) throw new NullException("The name of the end location can't be a null");
                System.out.print("Enter coordinate X of the end location: ");
                Double lx = scanner.nextDouble();
                    //if(lx == null) throw new NullException("The coordinate X of the end location can't be a null");
                System.out.print("Enter coordinate Y of the end location: ");
                int ly = scanner.nextInt();
                System.out.print("Enter coordinate Z of the end location: ");
                Integer lz = scanner.nextInt();
                    //if(lz == null) throw new NullException("The coordinate Z of the end location can't be a null");
                locationTwo = new Location(locationName, lx, ly, lz);
            }
            case 'N', 'n' -> System.out.print("\nThe route " + name + " doesn't have an end location");
            default -> throw new IncorrectArgumentException("Should get Y/N, got " + locationExistence);
        }
        routesCreated++;
        /*double distance = 0.0;
        if(locationOne != null && locationTwo != null) {

        } else if(locationOne == null && locationTwo != null) {

        } else if(locationOne != null && locationTwo == null) {

        } else if(locationOne == null && locationTwo == null) {

        }*/
        return new Route(name, cords, locationOne, locationTwo, 2.0);
    }

    public static boolean isInt(String word) {
        try {
            Integer.parseInt(word);
            return true;
        } catch(Exception e) {
            return false;
        }
    }

    public static int getInt(String word) throws NonIntStringException {
        if(Globals.isInt(word)) {
            return Integer.parseInt(word);
        } else throw new NonIntStringException("Given argument is not a number");
    }
}
