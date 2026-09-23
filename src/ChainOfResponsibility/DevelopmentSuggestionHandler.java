package ChainOfResponsibility;

public class DevelopmentSuggestionHandler extends BaseMessageHandler {

    @Override
    public void handle(Message message) {

        if (message.getType() == MessageType.DEVELOPMENT_SUGGESTION) {

            System.out.println("Handling development suggestion...");
            System.out.println("From: " + message.getSenderEmail());
            System.out.println("Suggestion: " + message.getContent());

            System.out.println("Result: Suggestion logged and added to the development backlog.");

            System.out.println();

        } else {
            passToNext(message);
        }
    }
}
