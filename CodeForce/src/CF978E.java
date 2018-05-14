import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class CF978E {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int n = in.nextInt();
        int w = in.nextInt();
        int min = 0;
        int max = w;
        int sum = 0;

        for (int i = 0; i < n; i++) {
            int diff = in.nextInt();
            sum += diff;
            max = Math.min(max, w - sum);
            if (sum < 0) {
                min = Math.max(min, -sum);
            }

        }

        System.out.println(Math.max(0, max - min + 1));


    }

}
