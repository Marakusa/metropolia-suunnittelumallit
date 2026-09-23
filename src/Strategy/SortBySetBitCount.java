package Strategy;

import java.util.ArrayList;
import java.util.Arrays;

public class SortBySetBitCount implements SortingStrategy {
    private static int countBits(int n) {
        int cnt = 0;
        while (n > 0) {
            cnt += (n & 1);
            n = n >> 1;
        }
        return cnt;
    }

    @Override
    public ArrayList<Integer> execute(int[] arr) {
        // Convert int[] to Integer[] for custom comparator
        Integer[] arrInteger = new Integer[arr.length];

        for (int i = 0; i < arr.length; i++) {
            arrInteger[i] = arr[i];
        }

        // custom comparator
        Arrays.sort(arrInteger, (a, b) -> {
            int count1 = countBits(a);
            int count2 = countBits(b);

            // descending order of set bits
            if (count1 != count2) {
                return count2 - count1;
            }

            // maintain original order (stable behavior)
            return 0;
        });

        // Convert array to ArrayList and return
        return new ArrayList<>(Arrays.asList(arrInteger));
    }
}
