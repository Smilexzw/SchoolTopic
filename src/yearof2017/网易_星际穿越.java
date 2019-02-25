package yearof2017;

import java.util.Scanner;

public class 网易_星际穿越 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double h = sc.nextDouble();
        double x = (Math.sqrt(4 * h + 1) - 1) / 2;
        System.out.println(new Double(x).intValue());
    }
}
