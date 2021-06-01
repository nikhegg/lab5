package commands;
import core.ConsolerMode;
import misc.VectorCore;
import java.util.Scanner;

public class Clear extends AbCommand{
    private final VectorCore vector;

    /**
     * @param vector
     */
    public Clear(VectorCore vector) {
        super("clear", "Clears the collection", "clear", false);
        this.vector = vector;
    }

    /**
     * @param args
     * @param mode
     */
    public void execute(String[] args, ConsolerMode mode) {
        System.out.print("Are you sure that you want to clear the collection?\nType Y for \"yes\" or N for \"no\": ");
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        char confirmationLetter;
        if(line.split("").length > 1) confirmationLetter = 'F';
        else confirmationLetter = line.charAt(0);
        switch(confirmationLetter) {
            case 'Y':
            case 'y':
                this.vector.clear();
                System.out.println("The collection was successfully cleared");
                break;
            case 'N':
            case 'n':
                System.out.println("The clearance of the collection was aborted");
                break;
            default:
                System.out.println("Should get Y/N value, got " + line + "\nThe clearance of the collection was aborted");
                break;
        }
    }
}
