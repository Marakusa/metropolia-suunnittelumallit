package Visitor;

import java.util.Objects;

public class File implements FileSystemElement {
    private final String name;
    private final double sizeInMegabytes;

    public File(String name, double sizeInMegabytes) {
        this.name = Objects.requireNonNull(name, "name");
        if (name.isBlank()) {
            throw new IllegalArgumentException("File name must not be blank");
        }
        if (!Double.isFinite(sizeInMegabytes) || sizeInMegabytes < 0) {
            throw new IllegalArgumentException("File size must be a finite, non-negative value");
        }
        this.sizeInMegabytes = sizeInMegabytes;
    }

    public String getName() {
        return name;
    }

    public double getSizeInMegabytes() {
        return sizeInMegabytes;
    }

    @Override
    public void accept(FileSystemVisitor visitor) {
        Objects.requireNonNull(visitor, "visitor").visit(this);
    }
}
