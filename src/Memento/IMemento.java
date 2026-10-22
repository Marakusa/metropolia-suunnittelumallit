package Memento;

import java.util.UUID;

public interface IMemento {
    long id = UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE;
}
