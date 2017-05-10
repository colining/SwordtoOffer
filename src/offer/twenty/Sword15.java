package offer.twenty;

import Myjar.ListNode;

/**
 * Created by asus on 2017/3/22.
 */
public class Sword15 {
    public static void main(String[] arg) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        System.out.println(FindKthToTail(listNode, 3));
    }


    static public ListNode FindKthToTail(ListNode head, int k) {
        //判定是否头结点为空，或者k是不是不符合要求
        if (head == null || k <= 0)
            return null;
        ListNode ahead = head;
        ListNode behind = head;
        // 一个指针先向前走k步，如果链表没有那么长，就返回null
        for (int i = 0; i < k - 1; i++) {
            if (ahead.next == null)
                return null;
            ahead = ahead.next;
        }
        //两个指针开始一起走
        while (ahead.next != null) {
            ahead = ahead.next;
            behind = behind.next;
        }
        return behind;
    }

}
