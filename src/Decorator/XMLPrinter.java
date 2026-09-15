package Decorator;

public class XMLPrinter implements Printer {
    private final Printer printer;

    public XMLPrinter(Printer printer) {
        this.printer = printer;
    }

    public void print(String message) {
        printer.print("<message>" + message + "</message>");
    }
}
