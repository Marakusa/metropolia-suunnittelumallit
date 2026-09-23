package Strategy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class SortInWave implements SortingStrategy {
    @Override
    public ArrayList<Integer> execute(int[] arr) {
        int n = arr.length;

        // swap adjacent elements
        for (int i = 0; i < n - 1; i += 2) {
            int temp = arr[i];
            arr[i] = arr[i + 1];
            arr[i + 1] = temp;
        }

        ArrayList<Integer> output = new ArrayList<>();
        Collections.addAll(output, Arrays.stream(arr).boxed().toArray(Integer[]::new));
        return output;
    }
}
