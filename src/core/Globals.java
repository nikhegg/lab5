package core;
import exceptions.IncorrectArgumentException;
import exceptions.NonNumberStringException;
import exceptions.NullException;
import misc.Coordinates;
import misc.Location;
import misc.Route;
import java.util.Scanner;

public class Globals {
    private static double version = 2.3;
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
