package offer.twenty;

import Myjar.ListNode;

/**
 * Created by asus on 2017/3/22.
 */
public class Sword17 {
    public ListNode Merge2(ListNode list1, ListNode list2) {
        //递归，每次比较头结点，然后递归下一个
        if (list1 == null)
            return list2;
        else if (list2 == null)
            return list1;
        ListNode node = null;
        if (list1.val < list2.val) {
            node = list1;
            node.next = Merge2(list1.next, list2);
        } else {
            node = list2;
            node.next = Merge2(list1, list2.next);
        }
        return node;
    }

    public ListNode Merge1(ListNode list1, ListNode list2) {
        //空链表判断
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode head = null;
        ListNode currentnode = null;
        /*
        每次比较链表的头结点
         */
        while (list1 != null && list2 != null) {
            if (list1.val >= list2.val) {
                if (head == null) {
                    head = currentnode = list2;
                } else {
                    currentnode.next = list2;
                    currentnode = currentnode.next;
                }
                list2 = list2.next;
            } else {
                if (head == null) {
                    head = currentnode = list1;
                }
                else {
                    currentnode.next = list1;
                    currentnode = list1;
                }
                list1 = list1.next;
            }

        }
        if (list1 == null) {
            currentnode.next = list2;
        } else {
            currentnode.next = list1;
        }
        return head;
    }
}
