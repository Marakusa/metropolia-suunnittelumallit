package Proxy;

import java.time.LocalDate;

public interface DocumentAccess {
    String getId();

    LocalDate getCreationDate();

    String getContent(User user) throws AccessDeniedException;
}
