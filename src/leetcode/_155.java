package leetcode;

import java.util.Stack;

/**
 * @Auther: xuzhangwang
 * @Description: 155. 最小栈
 * 题目描述
 * 评论 (120)
 * 题解
 * 提交记录
 * 设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
 * <p>
 * push(x) -- 将元素 x 推入栈中。
 * pop() -- 删除栈顶的元素。
 * top() -- 获取栈顶元素。
 * getMin() -- 检索栈中的最小元素。
 * 示例:
 * <p>
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.getMin();   --> 返回 -2.
 */
public class _155 {
    private Stack<Integer> stackData;
    private Stack<Integer> stackMin;
    public static void main(String[] args) {
        _155 stackMin = new _155();
        stackMin.push(-2);
        stackMin.push(-0);
        stackMin.push(-3);
        System.out.println(stackMin.getMin());
        stackMin.pop();
        System.out.println(stackMin.top());
        System.out.println(stackMin.getMin());

    }

    public _155() {
        this.stackData = new Stack<>();
        this.stackMin = new Stack<>();
    }
    /** initialize your data structure here. */

    public void push(int x) {
        if (stackMin.isEmpty()) {
            stackMin.push(x);
        } else if (x <= getMin()){
            stackMin.push(x);
        }
        stackData.push(x);
    }

    public void pop() {
        if (stackData.isEmpty()) {
            throw new RuntimeException("your stack is empty");
        }
        int value = stackData.pop();
        if (value == getMin()) {
            stackMin.pop();
        }
    }

    public int top() {
        return stackData.peek();
    }

    public int getMin() {
        return stackMin.peek();
    }
}
