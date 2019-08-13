package leetcode;

/**
 * @author xuzhangwang
 * @date 2019/8/13
 */
public class _278第一个错误的版本 {

    public int firstBadVersion(int n) {
        int l = 1;
        int r = n;
        while (l <= r) {
            int mid = (r - l) / 2 + l;
            if (isBadVersion(mid) == false) {
                l = mid + 1;
            } else if (isBadVersion(mid - 1) == true) {
                r = mid - 1;
            } else {
                return mid;
            }
        }
        return 0;
    }


    boolean isBadVersion(int version) {
        return false;
    }
}
