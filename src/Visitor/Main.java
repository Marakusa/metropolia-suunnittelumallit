package Visitor;

public class Main {
    public static void main(String[] args) {
        Directory root = new Directory("root");
        Directory documents = new Directory("documents");
        Directory images = new Directory("images");

        root.addElement(new File("readme.txt", 1.5));
        root.addElement(documents);
        root.addElement(images);
        documents.addElement(new File("report.pdf", 4.2));
        documents.addElement(new File("notes.txt", 0.8));
        images.addElement(new File("photo.jpg", 3.6));

        SizeCalculatorVisitor sizeCalculator = new SizeCalculatorVisitor();
        root.accept(sizeCalculator);
        System.out.printf("Total file size: %.1f MB%n", sizeCalculator.getTotalSizeInMegabytes());

        SearchVisitor search = new SearchVisitor(".txt");
        root.accept(search);
        System.out.println("Text files:");
        for (File file : search.getMatchingFiles()) {
            System.out.println("- " + file.getName());
        }
    }
}
