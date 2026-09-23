package ChainOfResponsibility;

public class GeneralFeedbackHandler extends BaseMessageHandler {

    @Override
    public void handle(Message message) {

        if (message.getType() == MessageType.GENERAL_FEEDBACK) {

            System.out.println("Handling general feedback...");
            System.out.println("From: " + message.getSenderEmail());
            System.out.println("Feedback: " + message.getContent());

            System.out.println("Result: Feedback analyzed and response prepared.");

            System.out.println();

        } else {
            passToNext(message);
        }
    }
}
