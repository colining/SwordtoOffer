package offer.ten;

/**
 * Created by colin on 2017/3/17.
 */

import Myjar.ListNode;

import java.util.ArrayList;
import java.util.Stack;

public class Sword05 {
    /* ��β��ͷ��ӡ����
       ����һ��������β��ͷ��ӡ����ÿ������ֵ��
     */
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
            if (listNode != null)                    //��listcode����β���ʱ
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
