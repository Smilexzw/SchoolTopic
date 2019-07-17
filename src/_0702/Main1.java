package _0702;


import java.util.*;

/**
 * @author xuzhangwang
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] a = new int[26];
        int[] b = new int[26];
        Deque<Integer> dq = new LinkedList<>();
        int ca = 0;
        int cb = 0;

        for (int i = 0; i < 26; i++) {
            a[i] = sc.nextInt();
        }
        for (int i = 0; i < 26; i++) {
            b[i] = sc.nextInt();
        }

        for (int i = 0; i < 26 ; i++) {
            if (!dq.contains(a[i])) {
                dq.addLast(a[i]);
            } else {
                dq.addLast(a[i]);
                while (dq.contains(a[i])) {
                    ++ca;
                    dq.removeLast();
                }
            }

            if (!dq.contains(b[i])) {
                dq.addLast(b[i]);
            } else {
                dq.addLast(b[i]);
                while (dq.contains(b[i])) {
                    ++cb;
                    dq.removeLast();
                }
            }
        }


        if (ca == cb) {
            System.out.println("Draw");
        } else if (ca > cb) {
            System.out.println("Byte");
        } else {
            System.out.println("Draw");
        }
    }
}
