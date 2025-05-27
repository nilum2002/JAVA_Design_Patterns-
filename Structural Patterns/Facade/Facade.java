
class CPU {

    void start(){
        System.out.println("CPU started");
    }
    void execute(){
        System.out.println("CPU executing");
    }
    void stop(){
        System.out.println("CPU stopped");
    }

}


class Memory {

    void load(){
        System.out.println("Memory loaded");
    }
    
    void clear(){
        System.out.println("Memory cleared");
    }

}


class HardDrive {

    void read(){
        System.out.println("Hard Drive reading");
    }
    
    void write(){
        System.out.println("Hard Drive writing");
    }

}



class computer_facade {

    private final CPU cpu;
    private final Memory memory;
    private final HardDrive hardDrive;
    public computer_facade() {
        this.cpu = new CPU();
        this.memory = new Memory();
        this.hardDrive = new HardDrive();
    }
    public void startComputer() {
        cpu.start();
        memory.load();
        hardDrive.read();
        cpu.execute();
    }
    public void stopComputer() {
        cpu.stop();
        memory.clear();
        hardDrive.write();
    }
    
}








public class Facade {
    public static void main(String[] args) {
        computer_facade computer = new computer_facade();
        
        // Starting the computer
        System.out.println("Starting the computer...");
        computer.startComputer();
        
        // Stopping the computer
        System.out.println("Stopping the computer...");
        computer.stopComputer();
        System.out.println("Computer operations completed.");
    }
    
}
