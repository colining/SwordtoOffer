package offer.thirty;

import java.util.Stack;

/**
 * Created by asus on 2017/3/25.
 */
public class Sword22 {
    public static void main(String[] arg) {
        int push[] = {1, 2, 3, 4, 5};
        int pop1[] = {4, 5, 3, 2, 1};
        System.out.println(IsPopOrder(push, pop1));
    }

    static public boolean IsPopOrder(int push[], int pop[]) {
        if (push == null || pop == null)
            return false;
        Stack<Integer> stack = new Stack<Integer>();
        int popIndex = 0;
        for (int i = 0; i < push.length; i++) {
            stack.push(push[i]);
            while (!stack.isEmpty() && stack.peek() == pop[popIndex]) {
                stack.pop();
                popIndex++;
            }
        }

        return stack.isEmpty();
    }
}
