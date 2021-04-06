package core;
import exceptions.IncorrectArgumentException;
import exceptions.NonNumberStringException;
import exceptions.NullException;
import misc.Coordinates;
import misc.Location;
import misc.Route;
import java.util.Scanner;

public class Globals {
    private static double version = 2.1;
    private static String envPath = System.getenv("VECTOR_COLLECTION_V");
    private static long routesCreated = 0;

    public static double getVersion() {
        return version;
    }

    public static String getEnvPath() {
        return envPath;
    }

    public static long getRoutesCreated() {
        return routesCreated;
    }

    public static void incRoutesCreated() {
        routesCreated++;
    }

    public static void decRoutesCreated() {
        routesCreated--;
    }

    public static void modifyRoutesCreated(long number) {
        routesCreated = number;
    }

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
        incRoutesCreated();
        Double distance = null;
        if(locationOne != null && locationTwo != null) {
            distance = Math.sqrt(Math.pow(Math.abs((locationOne.getX() - locationTwo.getX())), 2) + Math.pow(Math.abs(locationOne.getY() - locationTwo.getY()), 2) + Math.pow(Math.abs(locationOne.getZ() - locationTwo.getZ()), 2));
            distance = (double) Math.round(distance * 100)/100;
        } else if(locationOne == null && locationTwo != null) {
            distance = Math.sqrt(Math.pow(Math.abs((cords.getX() - locationTwo.getX())), 2) + Math.pow(Math.abs(cords.getY() - locationTwo.getY()), 2) + Math.pow(Math.abs(locationTwo.getZ()), 2));
            distance = (double) Math.round(distance * 100)/100;
        } else if(locationOne != null && locationTwo == null) {
            distance = Math.sqrt(Math.pow(Math.abs((locationOne.getX() - cords.getX())), 2) + Math.pow(Math.abs(locationOne.getY() - cords.getY()), 2) + Math.pow(Math.abs(locationOne.getZ()), 2));
            distance = (double) Math.round(distance * 100)/100;
        }
        return new Route(name, cords, locationOne, locationTwo, distance);
    }

    public static boolean isInt(String word) {
        try {
            Integer.parseInt(word);
            return true;
        } catch(Exception e) {
            return false;
        }
    }

    public static int getInt(String word) throws NonNumberStringException {
        if(Globals.isInt(word)) return Integer.parseInt(word);
        else throw new NonNumberStringException("Given argument is not a number");
    }

    public static boolean isDouble(String word) {
        try {
            Double.parseDouble(word);
            return true;
        } catch(Exception e) {
            return false;
        }
    }

    public static double getDouble(String word) throws NonNumberStringException {
        if(Globals.isDouble(word)) return Double.parseDouble(word);
        else throw new NonNumberStringException("Given argument is not a number");
    }
}
