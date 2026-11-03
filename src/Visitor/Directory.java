package Visitor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Directory implements FileSystemElement {
    private final String name;
    private final List<FileSystemElement> children = new ArrayList<>();

    public Directory(String name) {
        this.name = Objects.requireNonNull(name, "name");
        if (name.isBlank()) {
            throw new IllegalArgumentException("Directory name must not be blank");
        }
    }

    public String getName() {
        return name;
    }

    public void addElement(FileSystemElement element) {
        children.add(Objects.requireNonNull(element, "element"));
    }

    public boolean removeElement(FileSystemElement element) {
        return children.remove(element);
    }

    public List<FileSystemElement> getChildren() {
        return Collections.unmodifiableList(children);
    }

    @Override
    public void accept(FileSystemVisitor visitor) {
        Objects.requireNonNull(visitor, "visitor").visit(this);
    }
}
