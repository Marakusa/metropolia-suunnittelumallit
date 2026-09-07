package Observer;

public class Main {
    public static void main(String[] args) {
        WeatherStation weatherStation = new WeatherStation();

        Observer observer1 = new Observer("Observer 1");
        Observer observer2 = new Observer("Observer 2");
        Observer observer3 = new Observer("Observer 3");

        weatherStation.registerObserver(observer1);
        weatherStation.registerObserver(observer2);
        weatherStation.registerObserver(observer3);

        Thread weatherThread = new Thread(weatherStation);
        weatherThread.start();

        try {
            Thread.sleep(10000);
            weatherStation.removeObserver(observer2);

            System.out.println("Observer 2 removed from the weather station.");

            Thread.sleep(10000);

            weatherStation.stop();
            weatherThread.interrupt();
            weatherThread.join();

            System.out.println("Weather station stopped.");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
