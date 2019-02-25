package yearof2017;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @Auther: xuzhangwang
 * @Description:
 */
public class 网易_分苹果 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double n = sc.nextInt();
        double sum = 0;
        ArrayList<Double> list = new ArrayList<Double>();
        for (int i = 0; i < n; i++) {
            double tmp = sc.nextInt();
            sum += tmp;
            list.add(tmp);
        }
        double ave = sum / n;
        double small_count = 0;
        double big_count = 0;
        double result = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == ave) continue;
            if (list.get(i) < ave && ((ave - list.get(i)) % 2 == 0)) {
                small_count += (ave - list.get(i));
            } else if (list.get(i) > ave && ((list.get(i) - ave) % 2 == 0)) {
                big_count += (list.get(i) - ave);
            } else {
                small_count += (ave - list.get(i));
                result = -1;
                break;
            }
        }
        if (small_count != big_count) {
            result = -1;
        } else {
            result = big_count / 2;
        }
        System.out.println(new Double(result).intValue());
    }
}
