import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class QRA2015 {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            String audienceSetString = in.next();
            int[] audienceSet = new int[n + 1];
            char[] chars = audienceSetString.toCharArray();
            for (int j = 0; j < chars.length; j++) {
                audienceSet[j] = chars[j] - '0';
            }
            System.out.println("Case #" + i + ": " + solve(audienceSet));
        }
    }

    public static int solve(int[] audienceSet) {
        int fd = 0;
        int sum = 0;
        for (int i = 0; i < audienceSet.length; i++) {
            if (i > sum) {
                int diff = i - sum;
                fd += diff;
                sum += diff;
            }
            sum += audienceSet[i];
        }
        return fd;
    }
}
