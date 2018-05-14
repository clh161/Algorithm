import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class CF978F {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int n = in.nextInt();
        int k = in.nextInt();
        List<Programmer> programmers = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int skill = in.nextInt();
            programmers.add(new Programmer(skill, i));
        }
        for (int i = 0; i < k; i++) {
            int a = in.nextInt() - 1;
            int b = in.nextInt() - 1;
            if (programmers.get(a).skill > programmers.get(b).skill) {
                programmers.get(a).hates++;

            } else if (programmers.get(b).skill > programmers.get(a).skill) {
                programmers.get(b).hates++;
            }
        }
        int[] mentors = new int[n];
        Collections.sort(programmers, Comparator.comparingInt(a -> a.skill));
        for (int i = 0; i < n; i++) {
            Programmer programmerA = programmers.get(i);
            int lb = lowerBound(programmers, programmerA.skill);
            mentors[programmerA.index] = lb - programmerA.hates + 1;

        }
        for (int i = 0; i < n; i++) {
            System.out.print(mentors[i]);
            System.out.print(" ");
        }
    }

    public static int lowerBound(List<Programmer> programmers, int value) {
        int low = 0;
        int high = programmers.size();
        while (low < high) {
            final int mid = (low + high) / 2;
            if (value <= programmers.get(mid).skill) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low - 1;
    }

    public static class Programmer {
        int skill;
        int index;
        int hates = 0;

        public Programmer(int skill, int index) {
            this.skill = skill;
            this.index = index;
        }
    }


}
