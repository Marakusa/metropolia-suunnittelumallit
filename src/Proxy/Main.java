package Proxy;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        library.addUnprotectedDocument(
                "public-1",
                LocalDate.of(2025, 1, 10),
                "This document is available to everyone."
        );
        library.addProtectedDocument(
                "confidential-1",
                LocalDate.of(2025, 2, 15),
                "This document contains confidential information."
        );

        User alice = new User("alice");
        User bob = new User("bob");
        AccessControlService accessControl = AccessControlService.getInstance();
        accessControl.grantAccess("confidential-1", alice.getUsername());

        DocumentAccess publicDocument = library.getDocument("public-1");
        DocumentAccess protectedDocument = library.getDocument("confidential-1");

        System.out.println("Public document created on " + publicDocument.getCreationDate());
        showContent(publicDocument, bob);
        System.out.println("Protected document created on " + protectedDocument.getCreationDate());
        showContent(protectedDocument, alice);
        showContent(protectedDocument, bob);
    }

    private static void showContent(DocumentAccess document, User user) {
        try {
            System.out.println(user.getUsername() + " reads: " + document.getContent(user));
        } catch (AccessDeniedException e) {
            System.out.println(e.getMessage());
        }
    }
}
