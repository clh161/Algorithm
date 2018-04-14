import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class QRD2018 {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            double a = in.nextDouble();
            System.out.println("Case #" + i + ":\n" + solve(a));
        }
    }

    public static String solve(double area) {
        if (area <= 1.414213) {
            double angle = Math.toRadians(45) - Math.acos(area / Math.sqrt(2));
            double coor[][] = new double[3][3];
            coor[0][0] = 0.5;
            coor[1][1] = Math.cos(angle) / 2;
            coor[1][2] = Math.sin(angle) / 2;
            coor[2][1] = -Math.sin(angle) / 2;
            coor[2][2] = Math.cos(angle) / 2;
            return toString(coor);
        } else {
            double angle = getAngle(area);
            double coor[][] = new double[3][3];
            coor[0][0] = Math.cos(angle) / 2;
            coor[0][1] = -Math.sin(angle) / 2;
            coor[0][2] = 0;
            coor[1][0] = Math.sin(angle) * Math.sin(Math.toRadians(45)) / 2;
            coor[1][1] = Math.cos(angle) * Math.cos(Math.toRadians(45)) / 2;
            coor[1][2] = Math.sin(Math.toRadians(45)) / 2;
            coor[2][0] = -Math.cos(angle) * Math.sin(Math.toRadians(45)) / 2;
            coor[2][1] = -Math.sin(angle) * Math.sin(Math.toRadians(45)) / 2;
            coor[2][2] = Math.cos(Math.toRadians(45)) / 2;
            return toString(coor);
        }
    }

    public static String toString(double[][] coor) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < coor.length; i++) {
            for (int j = 0; j < coor[i].length; j++) {
                sb.append(String.format("%.10f", coor[i][j]));
                sb.append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public static double getAngle(double area) {
        double min = Math.toRadians(0);
        double max = Math.toRadians(35.3);
        for (int i = 0; i < 20; i++) {
            double mid = (max + min) / 2;
            double a = Math.cos(mid) * Math.sqrt(2) + Math.sin(mid);
            if (a > area) {
                max = mid;
            } else {
                min = mid;
            }
        }
        return (max + min) / 2;
    }

}
