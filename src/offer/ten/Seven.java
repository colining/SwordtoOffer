package offer.ten;

/**
 * Created by asus on 2017/3/19.
 */
import java.util.Stack;

public class Seven {
    public  static  void  main(String [] arg)
    {
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

        public  void push(int node) {
//            while (stack2.size()!=0)                          //�ϴ�popʱ��ջ2���ܻ��в���Ԫ�أ������뵽�˷Ż�ջ1
//            {
//                stack1.push(stack2.pop());
//            }
            stack1.push(node);

        }

        public int pop() {
                if (stack2.isEmpty()) {                             //���ջ2�ǿյģ���ֱ��popջ2�������ջһ��ȡԪ��
                    while (stack1.size() != 0) {
                        stack2.push(stack1.pop());
                    }
                    stack1.empty();                                //�ŵ�ջ2��ջ2������ȷ���еĶ����ˣ�ջһ�Ϳ��������
                }
                return  stack2.pop();


        }
    }
}
