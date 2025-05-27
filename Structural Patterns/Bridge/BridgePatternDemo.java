interface Device{
    void turnOn();
    void turnOff();
    void setChannel(int channel);

}

class TV implements Device {
    private boolean on = false;
    private int channel = 1;
    @Override
    public void turnOn() {
        on = true;
        System.out.println("TV is now ON");
    }
    @Override   
    public void turnOff() {
        on = false;
        System.out.println("TV is now OFF");
    }
    @Override   
    public void setChannel(int channel) {
        if (on) {
            this.channel = channel;
            System.out.println("TV channel set to " + channel);
        } else {
            System.out.println("TV is OFF. Cannot set channel.");
        }
    }


}

class Radio implements Device {
    private boolean on = false;
    private int channel = 1;
    @Override
    public void turnOn() {
        on = true;
        System.out.println("Radio is now ON");
    }
    @Override   
    public void turnOff() {
        on = false;
        System.out.println("Radio is now OFF");
    }
    @Override   
    public void setChannel(int channel) {
        if (on) {
            this.channel = channel;
            System.out.println("Radio channel set to " + channel);
        } else {
            System.out.println("Radio is OFF. Cannot set channel.");
        }
    }
}// Abstraction
abstract class RemoteControl {
    protected Device device;

    public RemoteControl(Device device) {
        this.device = device;
    }

    public abstract void turnOn();
    public abstract void turnOff();
    public abstract void setChannel(int channel);
}

// Refined Abstraction
class BasicRemoteControl extends RemoteControl {
    public BasicRemoteControl(Device device) {
        super(device);
    }

    @Override
    public void turnOn() {
        device.turnOn();
    }

    @Override
    public void turnOff() {
        device.turnOff();
    }

    @Override
    public void setChannel(int channel) {
        device.setChannel(channel);
    }
}

// Client Code
public class BridgePatternDemo {
    public static void main(String[] args) {
        Device tv = new TV();
        RemoteControl remote = new BasicRemoteControl(tv);

        remote.turnOn();       // TV is ON
        remote.setChannel(5);  // TV channel set to 5
        remote.turnOff();      // TV is OFF

        Device radio = new Radio();
        remote = new BasicRemoteControl(radio);

        remote.turnOn();       // Radio is ON
        remote.setChannel(99); // Radio frequency set to 99
        remote.turnOff();      // Radio is OFF
    }
}
