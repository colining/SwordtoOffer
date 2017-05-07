package offer.thirty;

import java.util.Stack;

/**
 * Created by asus on 2017/3/25.
 */
public class Two {
    public  static  void  main(String [] arg)
    {
        int push[] = {1,2,3,4,5};
        int pop1[] = {4,5,3,2,1};
        System.out.println(Two(push, pop1));
    }
    static  public  boolean Two(int push[] ,int pop[])
    {
        if (push==null||pop==null)
            return false;
        Stack<Integer> stack = new Stack<Integer>();
        int popindex=0;
        for (int i = 0;i<push.length;i++)
        {
            stack.push(push[i]);
            while (!stack.isEmpty()&&stack.peek()==pop[popindex])
            {
                stack.pop();
                popindex++;
            }
        }

        return stack.isEmpty();
    }
}
