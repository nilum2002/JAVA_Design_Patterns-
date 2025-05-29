// Device Interface (Implementor)
// updated 
interface Device {
    void turnOn();
    void turnOff();
    void setStation(int station);
}

// AbstractDevice to reduce code duplication
abstract class AbstractDevice implements Device {
    protected boolean on = false;
    protected int station = 1;

    @Override
    public void turnOn() {
        on = true;
        System.out.println(this.getClass().getSimpleName() + " is now ON");
    }

    @Override
    public void turnOff() {
        on = false;
        System.out.println(this.getClass().getSimpleName() + " is now OFF");
    }

    @Override
    public void setStation(int station) {
        if (on) {
            this.station = station;
            System.out.println(this.getClass().getSimpleName() + " station set to " + station);
        } else {
            System.out.println(this.getClass().getSimpleName() + " is OFF. Cannot set station.");
        }
    }
}

// Concrete Devices
class TV extends AbstractDevice {
    // Inherits all from AbstractDevice
}

class Radio extends AbstractDevice {
    // Inherits all from AbstractDevice
}

// Abstraction
abstract class RemoteControl {
    protected Device device;

    public RemoteControl(Device device) {
        this.device = device;
    }

    public abstract void turnOn();
    public abstract void turnOff();
    public abstract void setStation(int station);
}

// Refined Abstraction - Basic
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
    public void setStation(int station) {
        device.setStation(station);
    }
}

// Refined Abstraction - Advanced
class AdvancedRemoteControl extends BasicRemoteControl {
    public AdvancedRemoteControl(Device device) {
        super(device);
    }

    public void mute() {
        System.out.println("Muting the device.");
    }

    public void nextStation() {
        System.out.println("Going to next station.");
        device.setStation(((AbstractDevice) device).station + 1);
    }
}

// Client
public class BridgePatternDemo {
    public static void main(String[] args) {
        Device tv = new TV();
        RemoteControl remote = new BasicRemoteControl(tv);

        remote.turnOn();        // TV is ON
        remote.setStation(5);   // TV station set to 5
        remote.turnOff();       // TV is OFF

        System.out.println();

        Device radio = new Radio();
        AdvancedRemoteControl advRemote = new AdvancedRemoteControl(radio);

        advRemote.turnOn();        // Radio is ON
        advRemote.setStation(99);  // Radio station set to 99
        advRemote.nextStation();   // Go to 100
        advRemote.mute();          // Mute
        advRemote.turnOff();       // Radio is OFF
    }
}
