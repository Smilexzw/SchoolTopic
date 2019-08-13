//package jvm;
//
//import java.util.List;
//
///**
// * 当泛型遇见重载
// * 参数List<Integer>和List<String>编译之后，泛型就擦除了
// * @author xuzhangwang
// */
//public class GenericTypes {
//
//    public static void method1(List<String> list) {
//        System.out.println("invoke method(List<String) list");
//    }
//
//    public static void method(List<Integer> list) {
//        System.out.println("invoke method(List<String) list");
//    }
//
//
//    public String fun(int a) {
//        return "";
//    }
//
//    public int fun(int a) {
//        return 1;
//    }
//
//
//    public static void main(String[] args) {
//
//    }
//}
