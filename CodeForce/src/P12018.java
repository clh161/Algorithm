import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class P12018 {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            int min = in.nextInt() + 1;
            int max = in.nextInt();
            int n = in.nextInt();
            for (int j = 0; j < n; j++) {
                int mid = (min + max) / 2;
                System.out.println(mid);
                String result = in.next();
                if (result.equals("CORRECT"))
                    j = n;
                if (result.equals("TOO_SMALL"))
                    min = mid + 1;
                else max = mid - 1;
            }
        }
    }
}
