import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class A1A2016 {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            String s = in.next();
            System.out.println("Case #" + i + ": " + solve(s));
        }
    }

    public static String solve(String str) {
        String original = str;
        str = str.toUpperCase();
        char max = str.charAt(0);
        StringBuilder sb = new StringBuilder();
        sb.append(max);
        for (int i = 1; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c >= max) {
                sb.insert(0, original.charAt(i));
                max = c;
            } else {
                sb.append(original.charAt(i));
            }
        }
        return sb.toString();
    }

}
