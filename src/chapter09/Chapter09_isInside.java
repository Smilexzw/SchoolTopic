package chapter09;

/**
 * @Auther: xuzhangwang
 * @Description: 判断一个点是否在矩形内部
 * 在二维坐标系中， 所有的值都是double的类型，那么一个矩形就可以用由四个点代表的（x1, y1）(x2,y2) (x3, y3) (x4, y4)
 * 给定四个点代表矩形， 在给定一个点(x,y) 判断这个点是否在这个矩阵当中
 */
public class Chapter09_isInside {
    public static void main(String[] args) {

    }

    /**
     * 当前的情况是矩阵的边平行与当前的坐标系的x轴和y轴
     * @param x1 最左的点
     * @param y1
     * @param x4 最右的点
     * @param y4
     * @param x
     * @param y
     * @return
     */
    public static boolean isInside(double x1, double y1, double x4, double y4, double x, double y) {
        if (x <= x1 || x >= x4) {
            return false;
        }
        if (y <= y1 || y >= y4) {
            return false;
        }
        return true;
    }

    public static boolean isInside(double x1, double y1, double x2, double y2,
                                   double x3, double y3, double x4, double y4, double x, double y) {
        if (y1 == y2) {
            return isInside(x1, y1, x4, y4, x, y);
        }
        double l = Math.abs(y4 - y3);
        double k = Math.abs(x4 - y3);
        double s = Math.sqrt(k * k + l * l);
        double sin = l / s;
        double cos = k / s;
        double x1R = cos * x1 + sin * y1;
        double x4R = -x1 * sin + y1 * cos;
        double y1R = cos * x4 + sin * y4;
        double y4R = -x4 * sin + y4 * cos;
        double xR = cos * x + sin * y;
        double yR = -x * sin + y * cos;
        return isInside(x1R, y1R, x4R, y4R, xR, yR);
    }

}
