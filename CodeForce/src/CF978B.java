import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class CF978B {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int n = in.nextInt();
        String str = in.next();
        int count = 0;
        int remove = 0;
        for (int i = 0; i < n; i++) {
            char c = str.charAt(i);
            if (c == 'x') {
                count++;
                if (count > 2)
                    remove++;
            } else {
                count = 0;
            }
        }
        System.out.println(remove);

    }


}
