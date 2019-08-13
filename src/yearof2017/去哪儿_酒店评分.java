package yearof2017;

import java.util.*;

/**
 *
 *
 * 1.优先按照最低星数进行排序，最低星数高者居前。

 2.在最低星数相同时，按照平均星数排序，平均星数高者居前。

 3.如果最低星数和平均星数均相同，则序号（数据里出现的顺序编号，从0开始）小者居前。


 * 1.优先按照最低星数进行排序，最低星数高者居前。

 2.在最低星数相同时，按照平均星数排序，平均星数高者居前。

 3.如果最低星数和平均星数均相同，则序号（数据里出现的顺序编号，从0开始）小者居前。



 5

 4 4 5 3 4

 3 3 3 3 3

 5 4 4 3 5

 5 5 5 5 5

 5 2 4 3 4



 输出
 排序后的酒店序号（数据里出现的顺序编号，从0开始）

 样例输出
 3 2 0 1 4
 * @author xuzhangwang
 * @date 2019/8/8
 */
public class 去哪儿_酒店评分 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<double[]> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            double[] arr = new double[3];
            int sum = 0;
            int min  = Integer.MAX_VALUE;
            for (int j = 0; j < 5; j++) {
                int t = sc.nextInt();
                sum += t;
                min = Math.min(min, t);
            }
            arr[0] = i;
            arr[1] = min;
            arr[2] = sum / 5.0;
            list.add(arr);
        }

        Collections.sort(list, new Comparator<double[]>() {
            @Override
            public int compare(double[] o1, double[] o2) {
                if (o1[1] > o2[1]) {
                    return 1;
                }
                if (o1[1] == o2[1]) {
                    if (o1[2] > o2[2]) {
                        return 1;
                    }
                    if (o1[2] == o2[2]) {
                        if (o1[0] < o2[0]) {
                            return 1;
                        }
                        return -1;
                    }
                    return -1;
                }
               return -1;
            }
        });

        Collections.reverse(list);
        for (double[] doubles : list) {
            System.out.println(Arrays.toString(doubles));
        }

        for (double[] doubles : list) {
            System.out.print((int) doubles[0] + " ");
        }
    }
}
