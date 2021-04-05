package core;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileOperator {
    private String path;
    private File file;

    FileOperator(String path) {
        this.path = path;
        this.file = new File(path);
    }

    public String readFile() throws FileNotFoundException {
        Scanner fsc = new Scanner(this.file);
        String content = "";
        while(fsc.hasNextLine()) {
            content += fsc.nextLine();
        }
        return content;
    }

    public void writeFile() {

    }

}
