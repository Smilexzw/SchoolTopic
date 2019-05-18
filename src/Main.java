public class Main {

    public static void main(String[] args) {
        char[] chas = {'3', '7', '2', '1', '3', '4', '9', '2', '8'};
        heapSort(chas);
        for (int i = 0; i < chas.length; i++) {
            System.out.print(chas[i] + "\t");
        }
    }

    /*
        情况二下的解决的方法,书上的方法是说时间复杂度情况要低就考虑的（快排，归并，shell，堆排序）
        1、归并排序首先被被排除，因为归并排序是中有来两个的小的组合合并成为一个大的组合的过程，这个过程需要辅助数组才嗯那个完成
        即使归并排序可以使用手摇算法将额外的空间复杂度降至O（1）但是最差的情况下会上升到O（N^2）
        2、快排无论使用递归还非递归的情况进行实现， 最低的四件复杂度都是O（logN）
        3、shell排序时间复杂度也是不稳定的，成败完全在步长的选择上
        4、使用堆排序，堆排序的时间复杂度最低，但是大部分的资料提供的是基于递归的方法实现。但是递归函数使用函数栈空间，空间复杂度会上升到O（logN）
     */
    private static boolean isUnique2(char[] chas) {
        if (chas == null) return true;
        heapSort(chas);
        // 以上使用到归并排序进行将数组重新进行排序了
        for (int i = 1; i < chas.length; i++) {
            // 如果归并排序之后，数组中的chas[i] = chas[i - 1]，就代表的是数组出现重复的字符
            if (chas[i] == chas[i - 1]) {
                return false;
            }
        }
        return true;
    }

    private static void heapSort(char[] chas) {
        for (int i = 0; i < chas.length; i++) {
            heapInsert(chas, i);
        }
        for (int i = chas.length - 1; i > 0 ; i--) {
            swap(chas, 0, i);
            heapify(chas, 0 , i);
        }
    }

    /*
        在二叉树中，父亲结点的序号的是parent=（i - 1) / 2;
     */
    private static void heapInsert(char[] chas, int i) {
        int parent = 0;
        while (i != 0) {
            // 第一次，如果当前的i ！= 0代表的是还没有到根节点, 判断子节点是否是大于父亲结点的
            parent = (i - 1) / 2;
            if (chas[parent] < chas[i]) {
                swap(chas, parent, i);
                /*
                     当i！=0的情况下，会一直进行比较类似于一下情况
                                     （7）
                                    /     \
                                 (3)      (8)
                                /
                              (11)
                      11这个结点会一直进行比较，直到自己找到自己的位置
                */
                i = parent;
            } else {
                break;
            }
        }
    }

    // 兄弟结点进行比较，进行位置的修改,每次把最大的放在根结点在交换到当前的最后
    private static void heapify(char[] chas, int i, int size) {
        int left = i * 2 + 1;
        int right = i * 2 + 2;
        int largest = i;
        while (left < size) {
            if (chas[left] > chas[i]) {
                largest = left;
            }
            if (right < size && chas[right] > chas[largest]) {
                largest = right;
            }
            if (largest != i) {
                swap(chas, largest, i);
            } else {
                break;
            }
            i = largest;
            left = i * 2 + 1;
            right = i * 2 + 2;
        }
    }

    /*
        父亲结点与子节点进行交换
     */
    private static void swap(char[] chas, int index1, int index2) {
        char tmp = chas[index1];
        chas[index1] = chas[index2];
        chas[index2] = tmp;
    }
}
