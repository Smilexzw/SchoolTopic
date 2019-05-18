package code;

import java.util.Arrays;
import java.util.BitSet;
import java.util.Random;

/**
 * @author 8  * @date Time:
 * @des:
 */
public class Bitmap {
    int ARRNUM = 800;
    int LEN_INT = 32;
    int mmax = 9999;
    int mmin = 1000;
    int N = mmax - mmin + 1;

    public static void main(String args[]) {
        new Bitmap().findDuplicate();
        new Bitmap().findDup_jdk();
    }

    public void findDup_jdk() {
        System.out.println("*******调用JDK中的库方法--开始********");
        BitSet bitArray = new BitSet(N);
        int[] array = getArray(ARRNUM);
        for (int i = 0; i < ARRNUM; i++) {
            bitArray.set(array[i] - mmin);
        }
        int count = 0;
        for (int j = 0; j < bitArray.length(); j++) {
            if (bitArray.get(j)) {
                System.out.print(j + mmin + " ");
                count++;
            }
        }
        System.out.println();
        System.out.println("排序后的数组大小为：" + count );
        System.out.println("*******调用JDK中的库方法--结束********");
    }
    //下面是自己实现的方法：
    public void findDuplicate() {
        int[] array = getArray(ARRNUM);
        int[] bitArray = setBit(array);
        printBitArray(bitArray);
    }

    public void printBitArray(int[] bitArray) {
        int count = 0;
        for (int i = 0; i < N; i++) {
            if (getBit(bitArray, i) != 0) {
                count++;
                System.out.print(i + mmin + "\t");
            }
        }
        System.out.println();
        System.out.println("去重排序后的数组大小为：" + count);
    }

    public int getBit(int[] bitArray, int k) {// 1右移 k % 32位 与上 数组下标为 k/32 位置的值
        return bitArray[k / LEN_INT] & (1 << (k % LEN_INT));
    }

    public int[] setBit(int[] array) {// 首先取得数组位置下标 i/32, 然后 或上
        // 在该位置int类型数值的bit位：i % 32
        int m = array.length;
        int bit_arr_len = N / LEN_INT + 1;
        int[] bitArray = new int[bit_arr_len];
        for (int i = 0; i < m; i++) {
            int num = array[i] - mmin;
            bitArray[num / LEN_INT] |= (1 << (num % LEN_INT));
        }
        return bitArray;
    }

    public int[] getArray(int ARRNUM) {

        @SuppressWarnings("unused")
        int array1[] = { 1000, 1002, 1032, 1033, 6543, 9999, 1033, 1000 };

        int array[] = new int[ARRNUM];
        System.out.println("数组大小：" + ARRNUM);
        Random r = new Random();
        for (int i = 0; i < ARRNUM; i++) {
            array[i] = r.nextInt(N) + mmin;
        }

        System.out.println(Arrays.toString(array));
        return array;
    }
}