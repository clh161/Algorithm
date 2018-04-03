import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class CF957A {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int len = in.nextInt();
        if (len == 0)
            System.out.println("NO");
        else
            System.out.println(solve(in.next()));
    }

    public static String solve(String str) {
        if (str.contains("MM") || str.contains("CC") || str.contains("YY"))
            return "NO";
        if (str.contains("???") || str.contains("??") || str.equals("?"))
            return "YES";
        for (int i = 1; i < str.length() - 1; i++) {
            if (str.charAt(i) == '?' && str.charAt(i - 1) != '?' && str.charAt(i + 1) != '?')
                if (str.charAt(i - 1) == str.charAt(i + 1))
                    return "YES";
        }
        if (str.length() > 1)
            if (str.charAt(0) == '?' || str.charAt(str.length() - 1) == '?')
                return "YES";
        return "NO";
    }
}
