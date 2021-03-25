package commands;

public class LightOnCommand extends AbCommand {
    private Light light;

    public LightOnCommand(Light light) {
        super("switch", "Enables to turn on/off a light");
        this.light = light;
    }

    @Override
    public void execute() {
        if(this.light.getStatus()) this.light.off();
        else this.light.on();
    }
}
