import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class P22018 {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            int p = in.nextInt();
            int[] parties = new int[p];
            for (int j = 0; j < p; j++) {
                parties[j] = in.nextInt();
            }
            System.out.println("Case #" + i + ": " + solve(parties));
        }
    }

    public static String solve(int[] parties) {
        StringBuilder ans = new StringBuilder();
        int count = 0;
        for (int party : parties) {
            count += party;
        }
        while (count > 0) {
            int toLeave = count == 3 ? 1 : 2;
            for (int i = 0; i < toLeave; i++) {
                int maxIndex = 0;
                for (int j = 0; j < parties.length; j++)
                    if (parties[j] > parties[maxIndex])
                        maxIndex = j;
                parties[maxIndex]--;
                ans.append((char) (maxIndex + 'A'));
                count--;
            }
            if (count != 0)
                ans.append(" ");
        }
        return ans.toString();
    }
}
