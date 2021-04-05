package core;
import commands.*;
import misc.VectorCore;

public class Main {
    public static void main(String[] args) {
        VectorCore collection = new VectorCore();
        Commander commander = new Commander(
                new AddElement(collection),
                new AddIfMin(collection),
                new Clear(collection),
                new CountLessThanDistance(collection),
                new FilterByDistance(collection),
                new Help(),
                new Info(collection),
                new MinByDistance(collection),
                new RemoveByID(collection),
                new RemoveLast(collection),
                new Save(collection),
                new Show(collection),
                new Sort(collection),
                new UpdateID(collection));
        //FileOperator fileOperator = new FileOperator(Globals.envPath);
        Consoler consoler = new Consoler(commander);
        consoler.start();
    }
}
