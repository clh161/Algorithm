import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class CF978D {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int n = in.nextInt();
        int[] elements = new int[n];
        for (int i = 0; i < n; i++) {
            int e = in.nextInt();
            elements[i] = e;
        }
        if (n < 3) {
            System.out.println(0);
            return;
        }
        int diff = elements[1] - elements[0];
        int ans = -1;
        int de = 1;
        int dd = 2;
        for (int i = 0; i < 15; i++) {
            if (i != 0) {
                if (dd == -2) {
                    dd = 2;
                    de--;
                } else {
                    dd--;
                }
            }
            int count = getMin(elements, elements[0] + de, diff + dd, de == 0 ? 0 : 1);
            if (ans == -1 || (count < ans && count != -1)) {
                ans = count;
            }

        }
        System.out.println(ans);


    }

    public static int getMin(int[] elements, int first, int diff, int count) {
        int last = first;
        for (int i = 1; i < elements.length; i++) {
            int abs = Math.abs(elements[i] - last - diff);
            if (abs == 0) {
                last = last + diff;
            } else if (abs == 1) {
                last = last + diff;
                count++;
            } else {
                return -1;
            }
        }
        return count;
    }


}
