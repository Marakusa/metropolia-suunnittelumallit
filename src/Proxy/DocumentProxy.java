package Proxy;

import java.time.LocalDate;
import java.util.Objects;

public final class DocumentProxy implements DocumentAccess {
    private final Document document;
    private final AccessControlService accessControlService;

    DocumentProxy(Document document) {
        this.document = Objects.requireNonNull(document, "document");
        this.accessControlService = AccessControlService.getInstance();
    }

    @Override
    public String getId() {
        return document.getId();
    }

    @Override
    public LocalDate getCreationDate() {
        return document.getCreationDate();
    }

    @Override
    public String getContent(User user) throws AccessDeniedException {
        Objects.requireNonNull(user, "user");
        if (!accessControlService.isAllowed(document.getId(), user.getUsername())) {
            throw new AccessDeniedException(
                    "User '" + user.getUsername() + "' is not allowed to access document '" + document.getId() + "'."
            );
        }
        return document.getContent(user);
    }
}
