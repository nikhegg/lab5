package structure;
import commands.*;
import core.*;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        VectorCore collection = new VectorCore(); // Collection
        Info cmd = new Info(collection);
        //Invoker invoker = new Invoker(cmd); // Invoker
        Commander commander = new Commander(
                new AddElement(collection),
                new AddIfMin(collection),
                new Clear(collection),
                new CountLessThanDistance(collection),
                new ExecuteScript(),
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
        Consoler consoler = new Consoler(commander); // Console core
        consoler.start();
    }
}
