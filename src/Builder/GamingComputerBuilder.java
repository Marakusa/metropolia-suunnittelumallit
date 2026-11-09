package Builder;

public class GamingComputerBuilder implements ComputerBuilder {
    private Computer computer = new Computer();

    @Override
    public void buildProcessor() {
        computer.setProcessor("AMD Ryzen 9 7950X");
    }

    @Override
    public void buildRAM() {
        computer.setRamGb(32);
    }

    @Override
    public void buildHardDrive() {
        computer.setHardDrive("2 TB NVMe SSD");
    }

    @Override
    public void buildGraphicsCard() {
        computer.setGraphicsCard("NVIDIA GeForce RTX 4080");
    }

    @Override
    public void buildOperatingSystem() {
        computer.setOperatingSystem("Windows 11 Home");
    }

    @Override
    public Computer getResult() {
        Computer result = computer;
        computer = new Computer();
        return result;
    }
}
