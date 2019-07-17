//package _702;
//
//import java.util.Arrays;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.Scanner;
//
///**
// * @author xuzhangwang
// */
//public class 雀魂启动 {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int[] arr = new int[13];
//        for (int i = 0; i < 13; i++) {
//            arr[i] = sc.nextInt();
//        }
//        Arrays.sort(arr);
//        // 想法从剩下的26个牌子中一一尝试
//        Map<Integer, Integer> map = new HashMap<>();
//        for (int i = 1; i <= 9; i++) {
//            map.put(i, 4);
//        }
//
//        for (int i = 0; i < arr.length; i++) {
//            map.put(arr[i], map.get(arr[i]) - 1);
//        }
//
//
//        // 剩下中尝试
//
//        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
//            if (entry.getValue() == 0) continue;
//            fun(arr, entry.getKey());
//            System.out.println(entry.getKey() + " " +entry.getValue());
//        }
//    }
//
//    /**
//     * 验证是否合法
//     * @param arr
//     * @param key
//     * @return
//     */
//    private static boolean fun(int[] arr, Integer key) {
//        int[] a = new int[14];
//        for (int i = 0; i < 13; i++) {
//            a[i] = arr[i];
//        }
//        a[13] = key;
//        Arrays.sort(a);
//
//        // 使用递归
//        dfs(a, 0);
//    }
//
//    private static void dfs(int[] a, int i) {
//        if (i == 7) {
//
//        }
//    }
//}
