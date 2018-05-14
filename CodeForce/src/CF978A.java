import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class CF978A {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int n = in.nextInt();
        int[] l = new int[n];
        for (int i = 0; i < n; i++) {
            l[i] = in.nextInt();
        }

        Set<Integer> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        for (int i = l.length - 1; i >= 0; i--) {
            if (!set.contains(l[i])) {
                list.add(l[i]);
                set.add(l[i]);
            }
        }

        System.out.println(list.size());
        for (int i = list.size() - 1; i >= 0; i--) {
            System.out.print(list.get(i));
            System.out.print(" ");
        }

    }


}
