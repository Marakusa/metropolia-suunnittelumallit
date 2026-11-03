package Proxy;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public final class Library {
    private final Map<String, DocumentAccess> documents = new HashMap<>();

    public void addUnprotectedDocument(String id, LocalDate creationDate, String content) {
        addDocument(new Document(id, creationDate, content));
    }

    public void addProtectedDocument(String id, LocalDate creationDate, String content) {
        addDocument(new DocumentProxy(new Document(id, creationDate, content)));
    }

    public DocumentAccess getDocument(String id) {
        DocumentAccess document = documents.get(id);
        if (document == null) {
            throw new IllegalArgumentException("No document found with id '" + id + "'.");
        }
        return document;
    }

    private void addDocument(DocumentAccess document) {
        Objects.requireNonNull(document, "document");
        if (documents.putIfAbsent(document.getId(), document) != null) {
            throw new IllegalArgumentException("A document with id '" + document.getId() + "' already exists.");
        }
    }
}
