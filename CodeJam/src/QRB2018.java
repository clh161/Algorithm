import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class QRB2018 {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();


        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            int[] numbers = new int[n];
            for (int j = 0; j < n; j++) {
                numbers[j] = in.nextInt();
            }
            System.out.println("Case #" + i + ": " + solve(numbers));
        }
    }

    public static String solve(int[] numbers) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            int n = numbers[i];
            if (!map.containsKey(n))
                map.put(n, new ArrayList<>());
            map.get(n).add(i);
        }
        Arrays.sort(numbers);
        for (int i = 0; i < numbers.length; i++) {
            int n = numbers[i];
            List<Integer> integers = map.get(n);
            boolean found = false;
            for (int j = 0; j < integers.size(); j++) {
                if (integers.get(j) % 2 == i % 2) {
                    found = true;
                    integers.remove(j);
                    break;
                }
            }
            if (!found)
                return String.valueOf(i);
        }
        return "OK";
    }

}
