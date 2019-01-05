import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class CF1092C {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int n = in.nextInt();
        String[] strings = new String[n * 2 - 2];
        for (int i = 0; i < strings.length; i++) {
            strings[i] = in.next();
        }
        System.out.println(solve(strings, n));
    }

    public static String solve(String[] strings, int n) {
        char[] ans = new char[strings.length];
        List<Set<Character>> pairs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            pairs.add(new HashSet<>());
        }
        solve(strings, ans, new char[n], 0, pairs);


        StringBuilder sb = new StringBuilder();
        for (char an : ans) {
            sb.append(an);
        }
        return sb.toString();
    }

    public static boolean solve(String[] strings, char[] ans, char[] store, int i, List<Set<Character>> pairs) {
        if (i == strings.length) return true;
        char[] chars = strings[i].toCharArray();
        char[] original = new char[store.length];
        for (int j = 0; j < store.length; j++) {
            original[j] = store[j];
        }
        if (!pairs.get(chars.length - 1).contains('P')) {
            ans[i] = 'P';
            for (int j = 0; j < chars.length; j++) {
                if (store[j] == 0 || store[j] == chars[j]) {
                    store[j] = chars[j];
                    if (j == chars.length - 1) {
                        pairs.get(chars.length - 1).add('P');
                        if (solve(strings, ans, store, i + 1, pairs)) return true;
                        pairs.get(chars.length - 1).remove('P');
                    }

                } else {
                    break;
                }

            }
            for (int j = 0; j < store.length; j++) {
                store[j] = original[j];
            }
        }
        if (!pairs.get(chars.length - 1).contains('S')) {
            ans[i] = 'S';
            for (int j = 0; j < chars.length; j++) {
                if (store[store.length - j - 1] == 0 || store[store.length - j - 1] == chars[chars.length - j - 1]) {
                    store[store.length - j - 1] = chars[chars.length - j - 1];
                    if (j == chars.length - 1) {
                        pairs.get(chars.length - 1).add('S');
                        if (solve(strings, ans, store, i + 1, pairs)) return true;
                        pairs.get(chars.length - 1).remove('S');
                    }
                } else {
                    break;
                }

            }
            for (int j = 0; j < store.length; j++) {
                store[j] = original[j];
            }
        }
        return false;
    }
}
