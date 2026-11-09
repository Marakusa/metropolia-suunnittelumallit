package Builder;

public class Computer {
    private String processor;
    private int ramGb;
    private String hardDrive;
    private String graphicsCard;
    private String operatingSystem;

    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public int getRamGb() {
        return ramGb;
    }

    public void setRamGb(int ramGb) {
        this.ramGb = ramGb;
    }

    public String getHardDrive() {
        return hardDrive;
    }

    public void setHardDrive(String hardDrive) {
        this.hardDrive = hardDrive;
    }

    public String getGraphicsCard() {
        return graphicsCard;
    }

    public void setGraphicsCard(String graphicsCard) {
        this.graphicsCard = graphicsCard;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Processor:        ").append(processor).append('\n');
        sb.append("RAM:              ").append(ramGb).append(" GB\n");
        sb.append("Hard drive:       ").append(hardDrive).append('\n');
        sb.append("Graphics card:    ").append(graphicsCard).append('\n');
        sb.append("Operating system: ").append(operatingSystem);
        return sb.toString();
    }
}
