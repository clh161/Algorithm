import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class CF982A {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int n = in.nextInt();
        String seats = in.next();
        System.out.println(solve(n, seats));
    }

    private static String solve(int n, String seats) {
        if (seats.equals("0") || seats.endsWith("00") || seats.startsWith("00") || seats.contains("000") || seats.contains("11"))
            return "NO";
        return "YES";
    }

}
