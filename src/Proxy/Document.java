package Proxy;

import java.time.LocalDate;
import java.util.Objects;

final class Document implements DocumentAccess {
    private final String id;
    private final LocalDate creationDate;
    private final String content;

    Document(String id, LocalDate creationDate, String content) {
        this.id = Objects.requireNonNull(id, "id");
        this.creationDate = Objects.requireNonNull(creationDate, "creationDate");
        this.content = Objects.requireNonNull(content, "content");
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public LocalDate getCreationDate() {
        return creationDate;
    }

    @Override
    public String getContent(User user) {
        return content;
    }
}
