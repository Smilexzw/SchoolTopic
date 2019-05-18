package chapter01;

import java.util.Stack;

/**
 * @Auther: xuzhangwang
 * @Description:
 */
public class 设计一个有getMin功能的栈 {
    private static Stack<Integer> stackData = new Stack<>();
    private static Stack<Integer> stackMin = new Stack<>();

    public static void main(String[] args) {
        push(3);
        push(4);
        push(5);
        push(1);
        push(2);
        push(1);
//        System.out.println(pop());
//        System.out.println(pop());
//        System.out.println(pop());
//        System.out.println(pop());
//        System.out.println(pop());
//        System.out.println(pop());
        System.out.println(getMin());

    }

    /**
     * 模拟压栈的过程
     *
     * @param newNum
     */
    public static void push(int newNum) {
        if (stackData.isEmpty()) {
            stackMin.push(newNum);
        } else if (newNum <= getMin()) {
            stackMin.push(newNum);
        }
        stackData.push(newNum);
    }

    public static int pop() {
        if (stackData.isEmpty()) {
            throw new RuntimeException("Your stack is Empty!!!");
        }
        int value = stackData.pop();
        if (value == getMin()) {
            stackMin.pop();
        }
        return value;
    }

    public static int getMin() {
        if (stackMin.isEmpty()) {
            throw new RuntimeException("Your stack is empty!!!");
        }
        return stackMin.peek();
    }
}
