package exam;

import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * @Auther: xuzhangwang
 * @Description:
 */
public class test {
    public static void main(String[] args) {
       int co = 0;
       int num = 0;
        for (int i = 1; i <= 100; i++) {
            num += i;
            co = co++;
        }
        System.out.println("num * count =" + (num * co));
        double d1=-0.5;
        System.out.println("Ceil d1="+Math.ceil(d1));
        System.out.println("floor d1="+Math.floor(d1));
    }
    void fermin(int i){
        i++;
    }
}
