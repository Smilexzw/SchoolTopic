package yearof2017;

import java.util.*;

/**
 * @Auther: xuzhangwang
 * @Description:
 */
public class 网易_两种排序方式 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        List<String> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            list.add(sc.nextLine());
        }

        boolean istwo = true;
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i - 1).length() > list.get(i).length()) {
                istwo = false;
                break;
            }
        }
        List<String> isOne = new ArrayList<>(list);
        Collections.sort(list);
        boolean isone = true;
        for (int i = 0; i < list.size(); i++) {
            if (!list.get(i).equals(isOne.get(i))) {
                isone = false;
                break;
            }
        }
        if (isone == false && istwo == false) {
            System.out.println("none");
        } else if (isone == true && istwo == true) {
            System.out.println("both");
        } else if (isone == true && istwo == false){
            System.out.println("lexicographically");
        } else {
            System.out.println("lengths");
        }
    }
}
