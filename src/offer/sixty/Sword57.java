package offer.sixty;

import Myjar.ListNode;

/**
 * Created by colin on 2017/4/10.
 */
public class Sword57 {
    /* 删除链表中的重复结点
    在一个排序的链表中，存在重复的结点，
    请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
    例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
     */
    public static void main(String[] arg) {
        int[] a = {1, 1, 2, 2, 3, 4, 4, 5};
        ListNode node = new ListNode(a[0]);
        ListNode head = node;
        for (int i = 1; i < a.length; i++) {
            node.next = new ListNode(a[i]);
            node = node.next;
        }
        ListNode node1 = (deleteDuplication(head));
        while (node1 != null) {
            System.out.println(node1.val);
            node1 = node1.next;
        }
    }


    static public ListNode deleteDuplication(ListNode pHead) {
        //当前的结点
        ListNode currentNode = pHead;
        if (currentNode == null)
            return null;
        if (currentNode.next == null)
            return currentNode;
        //一个新的头结点，用来返回
        ListNode newHead = new ListNode(0);
        newHead.next = currentNode;
        //上一个不重复的结点
        ListNode pre = newHead;
        //currentNode一直向后移动，但是只有当它和后面的结点不同时，才保留在链表中
        while (currentNode != null && currentNode.next != null) {
            ListNode next = currentNode.next;         //下一个结点
            if (currentNode.val == next.val)          //相同就后移
            {
                while (next != null && currentNode.val == next.val) {
                    next = next.next;
                }
                pre.next = next;
                currentNode = next;
            } else {
                pre = currentNode;
                currentNode = currentNode.next;
            }

        }
        return newHead.next;
    }
}

