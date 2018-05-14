import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class CF978C {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int n = in.nextInt();
        int m = in.nextInt();
        long sum = 0;
        long[] sums = new long[n + 1];
        sums[0] = 0;
        for (int i = 0; i < n; i++) {
            long d = in.nextLong();
            sum += d;
            sums[i + 1] = sum;
        }
        for (int i = 0; i < m; i++) {
            long r = in.nextLong();
            int d = lowerBound(sums, sums.length, r);
            System.out.println((d) + " " + (r - sums[d - 1]));
        }


    }

    public static int lowerBound(long[] array, int length, long value) {
        int low = 0;
        int high = length;
        while (low < high) {
            final int mid = (low + high) / 2;
            if (value <= array[mid]) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }


}
