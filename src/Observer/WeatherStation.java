package Observer;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WeatherStation implements Runnable {
    private final List<Observer> observers = new ArrayList<>();

    private double temperature;

    private final double minTemperature = -30.0;
    private final double maxTemperature = 30.0;

    private boolean running = false;

    public WeatherStation() {
        Random random = new Random();
        temperature = random.nextDouble(minTemperature, maxTemperature);
    }

    public void registerObserver(Observer o) {
        observers.add(o);
    }

    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(temperature);
        }
    }

    public void stop() {
        running = false;
    }

    @Override
    public void run() {
        Random random = new Random();

        running = true;

        System.out.println("Weather Station running.");

        while (running) {
            try {
                int interval = random.nextInt(4) * 1000;
                Thread.sleep(interval);

                double delta = random.nextDouble(-1, 1);
                temperature += delta;

                if (temperature > maxTemperature) {
                    temperature = maxTemperature;
                } else if (temperature < minTemperature) {
                    temperature = minTemperature;
                }

                notifyObservers();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }
}
