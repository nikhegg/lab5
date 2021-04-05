package commands;
import misc.VectorCore;
import java.util.Scanner;
// DONE
public class Clear extends AbCommand{
    private final VectorCore vector;

    public Clear(VectorCore vector) {
        super("clear", "Clears the collection", "clear", false);
        this.vector = vector;
    }

    public void execute(String[] args) {
        System.out.print("Are you sure that you want to clear the collection?\nType Y for \"yes\" or N for \"no\": ");
        Scanner scanner = new Scanner(System.in);
        char confirmationLetter = scanner.nextLine().charAt(0);
        switch(confirmationLetter) {
            case 'Y', 'y' -> {
                this.vector.clear();
                System.out.println("The collection was successfully cleared");
            }
            case 'N', 'n' -> System.out.println("The clearance of the collection was aborted");
            default -> {

            }
        }
    }
}
