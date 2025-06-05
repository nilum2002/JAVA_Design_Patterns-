// Command Interface - Defines an interface for all command objects.
interface Command {
    void execute();  // Executes the command.
}

// Concrete Command 1 - Turns on the light.
class LightOnCommand implements Command {
    private final Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOn();  // Calls the action on the receiver (Light).
    }
}

// Concrete Command 2 - Turns off the light.
class LightOffCommand implements Command {
    private final Light light;

    public LightOffCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOff();  // Calls the action on the receiver (Light).
    }
}

// Receiver - The object that performs the actual action.
class Light {
    public void turnOn() {
        System.out.println("The light is ON");
    }

    public void turnOff() {
        System.out.println("The light is OFF");
    }
}

// Invoker - The object that asks the command to execute.
class RemoteControl {
    private Command command;

    // Set a command to be executed
    public void setCommand(Command command) {
        this.command = command;
    }

    // Executes the set command
    public void pressButton() {
        command.execute();
    }
}

// Client - Demonstrates the use of the Command pattern.
public class CommandPatternExample {
    public static void main(String[] args) {
        // Create the receiver (light) and the invoker (remote control)
        Light light = new Light();
        Command lightOn = new LightOnCommand(light);
        Command lightOff = new LightOffCommand(light);

        RemoteControl remote = new RemoteControl();

        // Turn the light on using the command
        remote.setCommand(lightOn);
        remote.pressButton();  // Output: The light is ON

        // Turn the light off using the command
        remote.setCommand(lightOff);
        remote.pressButton();  // Output: The light is OFF
    }
}