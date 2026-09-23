package ChainOfResponsibility;

public class ContactRequestHandler extends BaseMessageHandler {

    @Override
    public void handle(Message message) {

        if (message.getType() == MessageType.CONTACT_REQUEST) {

            System.out.println("Handling contact request...");
            System.out.println("From: " + message.getSenderEmail());
            System.out.println("Request: " + message.getContent());

            System.out.println("Result: Contact request forwarded to the appropriate department.");

            System.out.println();

        } else {
            passToNext(message);
        }
    }
}
