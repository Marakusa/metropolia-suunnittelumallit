package Adapter;

public class Main {
    public static void main(String[] args) {
        CalendarToNewDateAdapter dateAdapter = new CalendarToNewDateAdapter(java.util.Calendar.getInstance());

        dateAdapter.setDay(15);
        dateAdapter.setMonth(8); // 8 = August
        dateAdapter.setYear(2023);

        System.out.println("Current Date: " + dateAdapter.getDay() + "/" + dateAdapter.getMonth() + "/" + dateAdapter.getYear());

        // Advance the date by 10 days
        dateAdapter.advanceDays(10);
        System.out.println("New Date after advancing 10 days: " + dateAdapter.getDay() + "/" + dateAdapter.getMonth() + "/" + dateAdapter.getYear());

        // Advance the date by 25 days
        dateAdapter.advanceDays(25);
        System.out.println("New Date after advancing 25 days: " + dateAdapter.getDay() + "/" + dateAdapter.getMonth() + "/" + dateAdapter.getYear());

        // Advance the date by 365 days
        dateAdapter.advanceDays(365);
        System.out.println("New Date after advancing 365 days: " + dateAdapter.getDay() + "/" + dateAdapter.getMonth() + "/" + dateAdapter.getYear());
    }
}
