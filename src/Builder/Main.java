package Builder;

public class Main {
    public static void main(String[] args) {
        ComputerDirector director = new ComputerDirector(new GamingComputerBuilder());

        Computer gaming = director.constructComputer();
        print("Gaming computer", gaming);

        director.setBuilder(new OfficeComputerBuilder());

        Computer office = director.constructComputer();
        print("Office computer", office);
    }

    private static void print(String title, Computer computer) {
        System.out.println("=== " + title + " ===");
        System.out.println(computer);
        System.out.println();
    }
}
