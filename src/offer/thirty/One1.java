package offer.thirty;

import java.util.Stack;

/**
 * Created by asus on 2017/3/25.
 */
public class One1 {
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> min = new Stack<>();
    public void push(int node) {
        stack.push(node);
        if (min.size()==0||node<min.peek())
            min.push(node);
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
        assert (stack.size()>0&&min.size()>0);
      return min.peek();
    }
}
