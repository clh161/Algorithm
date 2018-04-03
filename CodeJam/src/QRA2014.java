import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class QRA2014 {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            int[] questions = new int[2];
            int[][][] cards = new int[2][4][4];
            for (int j = 0; j < 2; j++) {
                questions[j] = in.nextInt() - 1;
                for (int k = 0; k < 4; k++) {
                    for (int l = 0; l < 4; l++) {
                        cards[j][k][l] = in.nextInt();
                    }
                }
            }
            System.out.println("Case #" + i + ": " + solve(questions, cards));
        }
    }

    private static String solve(int[] questions, int[][][] cards) {
        Set<Integer> set = new HashSet<>();
        int ans = 0;
        for (int i = 0; i < questions.length; i++) {
            for (int j = 0; j < cards[i].length; j++) {
                if (i == 0) {
                    set.add(cards[i][questions[i]][j]);
                } else {
                    if (set.contains(cards[i][questions[i]][j])) {
                        if (ans != 0)
                            return "Bad magician!";
                        ans = cards[i][questions[i]][j];
                    }
                }
            }
        }
        if (ans == 0)
            return "Volunteer cheated!";
        return String.valueOf(ans);
    }

}
