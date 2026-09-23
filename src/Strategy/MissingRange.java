package Strategy;

import java.util.ArrayList;

public class MissingRange implements SortingStrategy {
    @Override
    public ArrayList<Integer> execute(int[] arr) {
        ArrayList<Integer> res = new ArrayList<>();

        // Find the minimum and maximum values in the array
        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;
        for (int x : arr) {
            if (x < low) low = x;
            if (x > high) high = x;
        }

        // Check every number in the given range
        for (int num = low; num <= high; num++) {

            boolean found = false;

            // Search current number in the array
            for (int x : arr) {
                if (x == num) {
                    found = true;
                    break;
                }
            }

            // If not present, add to result
            if (!found)
                res.add(num);
        }

        return res;
    }
}
