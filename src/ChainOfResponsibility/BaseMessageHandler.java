package ChainOfResponsibility;

public abstract class BaseMessageHandler implements MessageHandler {

    protected MessageHandler nextHandler;

    @Override
    public void setNextHandler(MessageHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    protected void passToNext(Message message) {
        if (nextHandler != null) {
            nextHandler.handle(message);
        } else {
            System.out.println("No handler found for message.");
        }
    }
}
