package offer.thirty;

import java.util.Iterator;
import java.util.Stack;

/**
 * Created by colin on 2017/3/25.
 */
public class Sword21 {
    /* 包含min函数的栈
    定义栈的数据结构，请在该类型中实现一个能够得到栈最小元素的min函数。
     */
    public static void main(String[] args) {

    }
    /*
    两种方法都没写当前栈为空的情况怎么处理，
     */
    static class fun1 {
        Stack<Integer> stack = new Stack<>();

        /*
        只在找最小值时做出判断，其实就是蛮力法
         */
        public void push(int node) {
            stack.push(node);
        }

        public void pop() {
            stack.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int min() {
            int min = stack.peek();
            int temp = 0;
            Iterator<Integer> iterator = stack.iterator();
            while (iterator.hasNext()) {
                temp = iterator.next();
                if (temp < min)
                    min = temp;
            }
            return min;
        }
    }

    static class fun2 {
        /*
        借助辅助栈，辅助栈总依次保存栈中可能的最小值；
         */
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> min = new Stack<>();

        public void push(int node) {
            stack.push(node);
            //如果压入的是第一个元素或者该元素比辅助栈栈顶元素还小，
            //就将该元素其压入
            if (min.size() == 0 || node < min.peek())
                min.push(node);
            //否则的话，压入一个当前的栈顶元素，就是说新来的这个元素不可能成为最小值
            else
                min.push(min.peek());
        }

        public void pop() {
            stack.pop();
            min.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int min() {
            return min.peek();
        }
    }
}
