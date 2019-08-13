package leetcode;

/**
 * @author xuzhangwang
 * @date 2019/7/31
 */
public class _743网络延迟 {
    private class Node implements Comparable<Node> {
        int i;
        int len;

        public Node(int i, int len) {
            this.i = i;
            this.len = len;
        }

        @Override
        public int compareTo(Node o) {
            int diff = len - o.len;
            if (diff > 1) {
                return 1;
            } else if (diff == 0){
                return 0;
            }
            return -1;
        }
    }

    /**
     * 使用优先队列来处理dijkstar算法
     * @param times
     * @param N
     * @param K
     * @return
     */
//    public int networkDelayTime(int[][] times, int N, int K) {
//        int[] minpath = new int[N];
//        for (int i = 0; i < N; i++) {
//            minpath[i] = Integer.MAX_VALUE;
//        }
//
//    }
}





