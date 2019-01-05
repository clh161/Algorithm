import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CF1095C {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int n = in.nextInt();
        int k = in.nextInt();
        int[] ans = solve(n, k);
        StringBuilder sb = new StringBuilder();
        if (ans.length == 0) {
            sb.append("NO");
        } else {
            sb.append("YES\n");
            for (int i = 0; i < ans.length; i++) {
                if (i != 0)
                    sb.append(" ");
                sb.append(ans[i]);
            }
        }
        System.out.println(sb.toString());
    }

    public static int[] solve(int n, int k) {
        List<Integer> ans = new ArrayList<>();
        int value = 1 << 30;
        while (n != 0 && value > 0) {
            if (value > n) {
                value >>= 1;
                continue;
            }
            ans.add(value);
            n -= value;
        }
        int i = 0;
        while (i < ans.size() && ans.size() < k) {
            if (ans.get(i) == 1) {
                i++;
                continue;
            }
            int j = ans.get(i);
            ans.set(i, j / 2);
            ans.add(j / 2);
        }
        if (n != 0 || k != ans.size()) return new int[0];
        ans.sort((a, b) -> a - b);
        int[] arr = new int[ans.size()];
        for (int l = 0; l < ans.size(); l++) {
            arr[l] = ans.get(l);
        }
        return arr;

    }

}
