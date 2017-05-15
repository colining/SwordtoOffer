package offer.twenty;

import Myjar.ListNode;

/**
 * Created by colin on 2017/3/22.
 */
public class Sword16 {
    /*反转链表
    输入一个链表，反转链表后，输出链表的所有元素。
     */
    public static void main(String[] arg) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        ReverseList1(listNode);
    }

    static public ListNode ReverseList1(ListNode head) {
        /*
        递归的方法
         */
        if (head == null || head.next == null) {
            return head;
        }
        ListNode node = ReverseList1(head.next);              //node设置为最后一个结点
        /*
        原链表进行反转
         */
        head.next.next = head;
        head.next = null;
        return node;
    }

    static public ListNode ReverseList2(ListNode head) {
        /*
        反转顺序的方法，需要每次储存三个结点
         */
        ListNode currentnode = head;
        ListNode prev = null;
        ListNode result = null;
        while (currentnode != null) {
            ListNode next = currentnode.next;
            if (next == null)
                result = currentnode;
            currentnode.next = prev;
            prev = currentnode;
            currentnode = next;
        }
        return result;
    }
}
