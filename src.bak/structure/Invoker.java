package structure;

public class Invoker {
    Command cmd;

    public Invoker(Command cmd) {
        this.cmd = cmd;
    }

    public void turnOn() {
        this.cmd.execute();
    }

}
