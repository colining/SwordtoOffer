package offer.ten;

/**
 * Created by asus on 2017/3/17.
 */

import Myjar.ListNode;

import java.util.ArrayList;
import java.util.Stack;

public class Sword05 {

    public class Solution {
        ArrayList arrayList = new ArrayList();

        public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
            if (listNode == null)
                return arrayList;

            solution(listNode);                    //进入递归
            return arrayList;
        }

        void solution(ListNode listNode)          //递归函数
        {
            if (listNode != null)                    //当listcode不是尾节点时
            {
                solution(listNode.next);           //递归
                arrayList.add(listNode.val);       //添加到类的属性中，这样就不会丢失了
            }

            return;
        }

        void solution1(ListNode listNode)          //建立栈
        {
            Stack<Integer> stack = new Stack<>();
            while (listNode != null) {
                stack.add(listNode.val);
                listNode = listNode.next;
            }

            while (!stack.isEmpty()) {
                arrayList.add(stack.pop());
            }
        }
    }


}
