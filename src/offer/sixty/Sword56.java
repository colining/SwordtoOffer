package offer.sixty;



import Myjar.ListNode;

import java.util.HashSet;

/**
 * Created by colin on 2017/4/10.
 */
public class Sword56 {
    /* 链表环的入口结点
    一个链表中包含环，请找出该链表的环的入口结点。
     */
    public static void main(String[] arg) {
        ListNode node = new ListNode(0);
        node.next = new ListNode(1);
        node.next.next = new ListNode(2);
        node.next.next.next = node.next;
        System.out.println(EntryNodeOfLoop1(node).val);
    }



    static public ListNode EntryNodeOfLoop1(ListNode pHead) {
        /*
        通过hashset，环连接结点要放两次
         */
        if (pHead == null)
            return null;
        ListNode node = pHead;
        HashSet<ListNode> hashSet = new HashSet<>();
        while (pHead != null) {
            if (hashSet.contains(node)) {
                return node;
            }
            hashSet.add(node);
            node = pHead.next;
            pHead = node;

        }
        return null;
    }

    static public ListNode EntryNodeOfLoop2(ListNode pHead) {
        /*
        通过断指针法，因为环连接结点有两个指向它的指针
         */
        if (pHead == null || pHead.next == null)
            return null;
        ListNode frontNode = pHead.next;
        ListNode backNode = pHead;

        while (frontNode != null) {
            backNode.next = null;
            backNode = frontNode;
            frontNode = frontNode.next;
        }
        return backNode;


    }

    static public ListNode EntryNodeOfLoop3(ListNode pHead) {
        /*
        p1指针提前向前移动环结点数目，然后p1,p2一起移动，
        它们就会同时到达环入口结点
         */
        ListNode meetingNode = FindMeetingNode(pHead);          //获取相遇结点
        if (meetingNode == null)                                //相遇结点没有话，证明没有环
            return null;
        int nodesInLoop = 1;                                    //环结点数目
        ListNode p1 = meetingNode;
        while (p1.next != meetingNode)                          //计算环结点数目
        {
            p1 = p1.next;
            ++nodesInLoop;
        }
        p1 = pHead;
        for (int i = 0; i < nodesInLoop; i++) {                 //p1指针向前走环结点数目
            p1 = p1.next;
        }
        ListNode p2 = pHead;                                    //p2指针为头结点
        while (p1 != p2)                                        //这时相遇时就是入口结点；
        {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }

    static public ListNode FindMeetingNode(ListNode pHead) {
        /*
        通过一快一慢两个指针寻找到一个环中的结点，并证明存在环
         */
        if (pHead == null)
            return null;
        ListNode slow = pHead.next;
        if (slow != null)
            return null;
        ListNode quick = slow.next;
        while (slow != null && quick != null) {
            if (slow == quick)
                return slow;
            slow = slow.next;
            quick = quick.next;

            if (slow != quick)
                quick = quick.next;
        }
        return null;
    }

}
