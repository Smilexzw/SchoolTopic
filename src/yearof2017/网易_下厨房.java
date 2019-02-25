package yearof2017;

import java.util.HashSet;
import java.util.Scanner;

public class 网易_下厨房 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashSet<String> set = new HashSet<String>();
        while(sc.hasNext()){
            String str = sc.nextLine();
            String arr[] = str.split(" ");
            for(int i=0; i<arr.length; i++){
                set.add(arr[i]);
            }
        }

        System.out.println(set.size());
        set.clear();
    }
}
