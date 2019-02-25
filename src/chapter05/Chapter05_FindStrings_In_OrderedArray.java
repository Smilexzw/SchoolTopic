package chapter05;

/**
 * @Auther: xuzhangwang
 * @Title: 在有序但含有空的数组中查找字符串
 * @Description: 给定的一个字符数组str[] 在str中有些位置为null，但在不为null的位置上，器字符串是按照的字典顺序进行排序的
 * 由小到大的依次出现的， 在给定一个字符串str的，清返回str在strs中出现最左边的位置
 * 如果str=null，只要str为null就返回的-1
 */
public class Chapter05_FindStrings_In_OrderedArray {
    public static void main(String[] args) {
        String[] strs = {null, "a", null, "a", null, "b", null, "c"};
        String str1 = "a";
        String str2 = null;
        String str3 = "d";
        int index1 = getIndex2(strs, str1);
        int index2 = getIndex2(strs, str2);
        int index3 = getIndex2(strs, str3);
        System.out.println(index1);
        System.out.println(index2);
        System.out.println(index3);
    }

    // 最简单的方法是使用for循环进行查找，时间复杂度是O（N）
    public static int getIndex1(String[] strs, String str) {
        if (strs == null || strs.length == 0 || str == null) {
            return -1;
        }
        for (int i = 0; i < strs.length; i++) {
            if (strs[i] != null &&strs[i].equals(str)) {
                return i;
            }
        }
        // 以上都不满足的，就代表是str不再strs中的，就返回-1
        return -1;
    }

    /*
        使用的是二分查找的方法进行处理
        全局整形变量res表示字符串str在strs中最左的位置。
     */
    public static int getIndex2(String[] strs, String str) {
        if (strs == null || strs.length == 0 || str == null) return -1;
        int res = -1;
        int left = 0;
        int right = strs.length - 1;
        int mid = 0;
        int i = 0;
        /*
            下面会出现三种情况，对三种情况进行的处理
            1、strs[mid] == str
            2、strs[mid] != str 并且strs[mid] != null
            3、strs[mid] != str 并且strs[mid] == null
        */
        while(left <= right) {
            mid = (left + right) / 2;
            if (strs[mid] != null && strs[mid].equals(str)) {
                res = mid;
                right = mid - 1;
            } else if (strs[mid] != null) {
                // 当mid不等于空的时候，比较两个字符的ASCII值的大小，如果strs[mid].compareTo(str), 如果小于0的话，证明的str比strs[mid]大
                if (strs[mid].compareTo(str) < 0) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {
                // 如果字符串strs[mid]与str不一样，并且strs[mid]==null，此时从mid开始，从右到左遍历左半区，如果左边的半区都为null的时候，在
                // 右边半区开始一次查找
                i = mid;
                while (strs[i] == null && --i >= left)
                    ;
                if (i < left || strs[i].compareTo(str) < 0) {
                    left = mid + 1;
                } else {
                    res = strs[i].equals(str) ? i : res;
                    right = i - 1;
                }
            }
        }
        return res;
    }
}
