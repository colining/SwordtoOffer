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

            solution(listNode);                    //����ݹ�
            return arrayList;
        }

        void solution(ListNode listNode)          //�ݹ麯��
        {
            if (listNode != null)                    //��listcode����β�ڵ�ʱ
            {
                solution(listNode.next);           //�ݹ�
                arrayList.add(listNode.val);       //��ӵ���������У������Ͳ��ᶪʧ��
            }

            return;
        }

        void solution1(ListNode listNode)          //����ջ
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
