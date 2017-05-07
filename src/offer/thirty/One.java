package offer.thirty;

import java.util.Iterator;
import java.util.Stack;

/**
 * Created by asus on 2017/3/25.
 */
public class One {
        Stack<Integer> stack = new Stack<>();

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
        while (iterator.hasNext())
        {
            temp=iterator.next();
            if (temp<min)
                min=temp;
        }
        return  min;
    }
}
