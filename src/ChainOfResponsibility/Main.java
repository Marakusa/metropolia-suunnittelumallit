package ChainOfResponsibility;

public class Main {

    public static void main(String[] args) {

        // Create handlers
        MessageHandler compensationHandler = new CompensationHandler();
        MessageHandler contactHandler = new ContactRequestHandler();
        MessageHandler developmentHandler = new DevelopmentSuggestionHandler();
        MessageHandler generalFeedbackHandler = new GeneralFeedbackHandler();

        // Build the chain
        compensationHandler.setNextHandler(contactHandler);
        contactHandler.setNextHandler(developmentHandler);
        developmentHandler.setNextHandler(generalFeedbackHandler);

        // Create customer messages
        Message message1 = new Message(MessageType.COMPENSATION_CLAIM, "My product was damaged during delivery. I would like a refund.", "alice@example.com");

        Message message2 = new Message(MessageType.CONTACT_REQUEST, "I would like to speak with someone from customer support.", "bob@example.com");

        Message message3 = new Message(MessageType.DEVELOPMENT_SUGGESTION, "It would be useful to have a mobile application.", "charlie@example.com");

        Message message4 = new Message(MessageType.GENERAL_FEEDBACK, "I really like your service, but the website could be faster.", "diana@example.com");

        // Send messages through the chain
        System.out.println("=== Customer Feedback Handler ===");
        System.out.println();

        compensationHandler.handle(message1);
        compensationHandler.handle(message2);
        compensationHandler.handle(message3);
        compensationHandler.handle(message4);
    }
}
