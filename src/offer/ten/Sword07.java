package offer.ten;

/**
 * Created by asus on 2017/3/19.
 */

import java.util.Stack;

public class Sword07 {
    public static void main(String[] arg) {
        Solution solution = new Solution();
        solution.push(1);
        solution.push(2);
        solution.push(3);
        System.out.println(solution.stack1);
        solution.pop();
        solution.pop();
        System.out.println(solution.stack2);
    }


    public static class Solution {
        Stack<Integer> stack1 = new Stack<Integer>();
        Stack<Integer> stack2 = new Stack<Integer>();
        /*
        栈一负责压入
         */
        public void push(int node) {
            stack1.push(node);
        }
        /*
        栈二负责弹出，如果栈二有元素，就直接弹出，否则就把栈一的元素倒进来；
        栈一倒入栈二顺序就颠倒了，就变成了队列
         */
        public int pop() {
            if (stack2.isEmpty()) {                             //都为空其实要做错误处理
                while (stack1.size() != 0) {
                    stack2.push(stack1.pop());
                }
            }
            return stack2.pop();
        }
    }
}
