import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            int a = in.nextInt();
            boolean done = false;
            Size size = new Size(a);
            while (!done) {
                Coor target = size.getTarget();
                System.out.println(target.getX() + " " + target.getY());
                System.out.flush();
                int fillX = in.nextInt();
                int fillY = in.nextInt();
                if (fillX == 0 && fillY == 0)
                    done = true;
                if (!done)
                    size.fill(fillX, fillY);
            }
        }
    }

    public static class Coor {
        private int x;
        private int y;

        public Coor(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Coor coor = (Coor) o;
            return x == coor.x &&
                    y == coor.y;
        }

        @Override
        public int hashCode() {

            return Objects.hash(x, y);
        }
    }

    public static class Size {

        private int a;
        private int width;
        private int height;
        private boolean[][] grid;
        private int minI = 1;

        public Size(int width, int height) {
            this.width = width;
            this.height = height;
        }

        public Size(int a) {
            if (a < 9) {
                width = 3;
                height = 3;
            } else {
                width = (int) Math.ceil(Math.sqrt(a));
                height = (int) Math.ceil((double) a / width);
            }
            grid = new boolean[width][height];
        }

        public void fill(int x, int y) {
            x--;
            y--;
            grid[x][y] = true;
        }

        public Coor getTarget() {
            int max = 0;
            int maxX = 0, maxY = 0;
            for (int i = minI; i < grid.length - 1; i++) {
                for (int j = 1; j < grid[i].length - 1; j++) {
                    int count = 0;
                    for (int k = i - 1; k < i + 2; k++) {
                        for (int l = j - 1; l < j + 2; l++) {
                            if (!grid[k][l]) {
                                count++;
                            }
                        }
                    }
                    if (count > max) {
                        max = count;
                        maxX = i;
                        maxY = j;
                        if (count == 9) return new Coor(maxX + 1, maxY + 1);
                    }
                }
                if (max == 0) minI = i + 1;
            }
            return new Coor(maxX + 1, maxY + 1);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Size size = (Size) o;
            return width == size.width &&
                    height == size.height;
        }

        @Override
        public int hashCode() {

            return Objects.hash(a, width, height);
        }
    }
}
