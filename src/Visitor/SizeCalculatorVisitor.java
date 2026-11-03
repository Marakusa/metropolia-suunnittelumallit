package Visitor;

public class SizeCalculatorVisitor implements FileSystemVisitor {
    private double totalSizeInMegabytes;

    @Override
    public void visit(File file) {
        totalSizeInMegabytes += file.getSizeInMegabytes();
    }

    @Override
    public void visit(Directory directory) {
        for (FileSystemElement child : directory.getChildren()) {
            child.accept(this);
        }
    }

    public double getTotalSizeInMegabytes() {
        return totalSizeInMegabytes;
    }
}
