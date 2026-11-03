package Visitor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

public class SearchVisitor implements FileSystemVisitor {
    private final String extension;
    private final List<File> matchingFiles = new ArrayList<>();

    public SearchVisitor(String extension) {
        Objects.requireNonNull(extension, "extension");
        String normalizedExtension = extension.startsWith(".")
                ? extension.substring(1)
                : extension;
        if (normalizedExtension.isBlank()) {
            throw new IllegalArgumentException("File extension must not be blank");
        }
        this.extension = normalizedExtension.toLowerCase(Locale.ROOT);
    }

    @Override
    public void visit(File file) {
        if (file.getName().toLowerCase(Locale.ROOT).endsWith("." + extension)) {
            matchingFiles.add(file);
        }
    }

    @Override
    public void visit(Directory directory) {
        for (FileSystemElement child : directory.getChildren()) {
            child.accept(this);
        }
    }

    public List<File> getMatchingFiles() {
        return Collections.unmodifiableList(matchingFiles);
    }
}
