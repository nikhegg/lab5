package core;
import exceptions.IncorrectArgumentException;
import exceptions.NullException;
import misc.Coordinates;
import misc.Location;
import misc.Route;
import java.util.Scanner;

public class RouteMaker {
    private Scanner scanner;

    public RouteMaker() {
        this.scanner = Consoler.getScanner();
    }

    public Route makeNewRoute(ConsolerMode mode) throws NullException, IncorrectArgumentException {
        //this.scanner = new Scanner(System.in);
        System.out.print("Enter the name of the new route: ");
        String name = this.scanner.nextLine();
        if(mode == ConsolerMode.SCRIPT) System.out.println(name);
        if(name == null) throw new NullException("The name of the route can't be a null");
        System.out.print("Enter coordinate X of the new route: ");
        //long cordX = this.scanner.nextLong();
        long cordX;
        try {
            cordX = Long.parseLong(this.scanner.nextLine());
        } catch(NumberFormatException e) {
            System.out.println("Coordinate X should be a number");
            return null;
        }

        if(mode == ConsolerMode.SCRIPT) System.out.println(cordX);
        System.out.print("Enter coordinate Y of the new route: ");
        //Integer cordY = this.scanner.nextInt();
        Integer cordY;
        try {
            cordY = Integer.parseInt(this.scanner.nextLine());
        } catch(NumberFormatException e) {
            System.out.println("Coordinate Y should be a number");
            return null;
        }

        if(mode == ConsolerMode.SCRIPT) System.out.println(cordY);
        Coordinates cords = new Coordinates(cordX, cordY);
        System.out.print("\nIs there a start location of the route? \nType Y for \"yes\" or N for \"no\": ");
        String locationName;
        char locationExistence = this.scanner.next().trim().charAt(0);
        if(mode == ConsolerMode.SCRIPT) System.out.println(locationExistence);
        Location locationOne = null;
        switch(locationExistence) {
            case 'Y', 'y' -> {
                System.out.print("\nEnter the name of the start location: ");
                locationName = this.scanner.nextLine();
                locationName = this.scanner.nextLine();
                if(mode == ConsolerMode.SCRIPT) System.out.println(locationName);
                if(locationName == null) throw new NullException("The name of the start location can't be a null");
                System.out.print("Enter coordinate X of the start location: ");
                //Double lx = this.scanner.nextDouble();
                Double lx;
                try {
                    lx = Double.parseDouble(this.scanner.nextLine());
                } catch(NumberFormatException e) {
                    System.out.println("Coordinate X should be a number");
                    return null;
                }

                if(mode == ConsolerMode.SCRIPT) System.out.println(lx);
                System.out.print("Enter coordinate Y of the start location: ");
                //int ly = this.scanner.nextInt();
                int ly;
                try {
                    ly = Integer.parseInt(this.scanner.nextLine());
                } catch(NumberFormatException e) {
                    System.out.println("Coordinate Y should be a number");
                    return null;
                }

                if(mode == ConsolerMode.SCRIPT) System.out.println(ly);
                System.out.print("Enter coordinate Z of the start location: ");
                //Integer lz = this.scanner.nextInt();
                Integer lz;
                try {
                    lz = Integer.parseInt(this.scanner.nextLine());
                } catch(NumberFormatException e) {
                    System.out.println("Coordinate Z should be a number");
                    return null;
                }

                if(mode == ConsolerMode.SCRIPT) System.out.println(lz);
                locationOne = new Location(locationName, lx, ly, lz);
            }
            case 'N', 'n' -> System.out.print("\nThe route " + name + " doesn't have a start location\n");
            default -> throw new IncorrectArgumentException("Should get Y/N, got " + locationExistence);
        }
        System.out.print("\nIs there an end location of the route? \nType Y for \"yes\" or N for \"no\": ");
        locationExistence = this.scanner.next().charAt(0);
        if(mode == ConsolerMode.SCRIPT) System.out.println(locationExistence);
        Location locationTwo = null;
        switch(locationExistence) {
            case 'Y', 'y' -> {
                System.out.print("\nEnter the name of the end location: ");
                locationName = this.scanner.nextLine();
                locationName = this.scanner.nextLine();
                if(mode == ConsolerMode.SCRIPT) System.out.println(locationName);
                if(locationName == null) throw new NullException("The name of the end location can't be a null");
                System.out.print("Enter coordinate X of the end location: ");
                //Double lx = this.scanner.nextDouble();
                Double lx;
                try {
                    lx = Double.parseDouble(this.scanner.nextLine());
                } catch(NumberFormatException e) {
                    System.out.println("Coordinate X should be a number");
                    return null;
                }

                if(mode == ConsolerMode.SCRIPT) System.out.println(lx);
                //if(lx == null) throw new NullException("The coordinate X of the end location can't be a null");
                System.out.print("Enter coordinate Y of the end location: ");
                //int ly = this.scanner.nextInt();
                int ly;
                try {
                    ly = Integer.parseInt(this.scanner.nextLine());
                } catch(NumberFormatException e) {
                    System.out.println("Coordinate Y should be a number");
                    return null;
                }

                if(mode == ConsolerMode.SCRIPT) System.out.println(ly);
                System.out.print("Enter coordinate Z of the end location: ");
                //Integer lz = this.scanner.nextInt();
                Integer lz;
                try {
                    lz = Integer.parseInt(this.scanner.nextLine());
                } catch(NumberFormatException e) {
                    System.out.println("Coordinate Z should be a number");
                    return null;
                }

                if(mode == ConsolerMode.SCRIPT) System.out.println(lz);
                //if(lz == null) throw new NullException("The coordinate Z of the end location can't be a null");
                locationTwo = new Location(locationName, lx, ly, lz);
            }
            case 'N', 'n' -> System.out.print("\nThe route " + name + " doesn't have an end location");
            default -> throw new IncorrectArgumentException("Should get Y/N, got " + locationExistence);
        }
        Globals.incRoutesCreated();
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
        scanner.nextLine();
        return new Route(name, cords, locationOne, locationTwo, distance);
    }
}