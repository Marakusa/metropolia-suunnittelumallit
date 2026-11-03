package Proxy;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public final class AccessControlService {
    private record Permission(String documentId, String username) {
    }

    private static final AccessControlService INSTANCE = new AccessControlService();
    private final Set<Permission> permissions = ConcurrentHashMap.newKeySet();

    private AccessControlService() {
    }

    public static AccessControlService getInstance() {
        return INSTANCE;
    }

    public void grantAccess(String documentId, String username) {
        permissions.add(new Permission(documentId, username));
    }

    public void revokeAccess(String documentId, String username) {
        permissions.remove(new Permission(documentId, username));
    }

    public boolean isAllowed(String documentId, String username) {
        return permissions.contains(new Permission(documentId, username));
    }
}
