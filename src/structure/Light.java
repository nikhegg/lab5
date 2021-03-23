package structure;

public class Light {
    private int turningsOn;
    private boolean isActive;

    public Light() {
        this.turningsOn = 0;
        this.isActive = false;
    }

    public void on() {
        if(!this.isActive) {
            this.isActive = true;
            this.turningsOn += 1;
            System.out.println("Lamp was activated. Current turnings on: " + this.turningsOn);
        }
    }

    public void off() {
        if(this.isActive) {
            this.isActive = false;
            System.out.println("Lamp was turned off. Current turnings on: " + this.turningsOn);
        }
    }

    public boolean getStatus() {
        return this.isActive;
    }
}
