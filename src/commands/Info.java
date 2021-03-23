package commands;

import core.VectorCore;

import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Info extends AbCommand {
    private final VectorCore vector;

    public Info(VectorCore vector) {
        super("info", "Shows the information about collection (created at, size, etc.)");
        this.vector = vector;
    }

    public void execute() {
        /*TODO  The process of getting VectorCore data
            VIA: vector.getCreationDate(), vector.getSize(), ...
         */
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        System.out.println("-----Collection info-----\nData Type: " + this.vector.getClass().getName() + "\nInitialisation Date: " + df.format(this.vector.getCreationDate()) +
                "\nCollection Size: " + this.vector.getSize() + "\n-------------------------\n");
    }
}
