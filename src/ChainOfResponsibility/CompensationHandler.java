package ChainOfResponsibility;

public class CompensationHandler extends BaseMessageHandler {

    @Override
    public void handle(Message message) {

        if (message.getType() == MessageType.COMPENSATION_CLAIM) {

            System.out.println("Handling compensation claim...");
            System.out.println("From: " + message.getSenderEmail());
            System.out.println("Claim: " + message.getContent());

            // Simple example of reviewing the claim
            if (message.getContent().toLowerCase().contains("damaged") || message.getContent().toLowerCase().contains("refund")) {

                System.out.println("Result: Compensation claim approved.");
            } else {
                System.out.println("Result: Compensation claim rejected.");
            }

            System.out.println();

        } else {
            passToNext(message);
        }
    }
}
