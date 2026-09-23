package ChainOfResponsibility;

public interface MessageHandler {

    void setNextHandler(MessageHandler nextHandler);

    void handle(Message message);
}
