package offer.sixty;

import java.util.HashSet;

/**
 * Created by asus on 2017/4/10.
 */
public class Six {
    public static  void main (String [] arg)
    {
        ListNode node = new ListNode(0);
        node.next = new ListNode(1);
        node.next.next = new ListNode(2);
        node.next.next.next = node.next;
        System.out.println(EntryNodeOfLoop1(node).val);
    }
    static public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    static public ListNode EntryNodeOfLoop(ListNode pHead)
    {
        if (pHead==null)
            return null;
        ListNode node = pHead;
        HashSet<ListNode> hashSet = new HashSet<>();
        while (pHead!=null)
        {
            if (hashSet.contains(node))
            {
                return node;
            }
            hashSet.add(node);
            node = pHead.next;
            pHead= node;

        }
        return  null;
    }
    static public ListNode EntryNodeOfLoop1(ListNode pHead)
    {
        if (pHead==null||pHead.next == null)
            return  null;
        ListNode frontnode = pHead.next;
        ListNode backnode  = pHead;

        while (frontnode!=null)
        {
            backnode.next = null;
            backnode = frontnode;
            frontnode =frontnode.next;
        }
        return backnode;


    }
    static public ListNode FindMeetingnode(ListNode pHead)
    {
        if (pHead==null)
            return null;
        ListNode slow = pHead.next;
        if (slow!=null)
            return null;
        ListNode quick = slow.next;
        while (slow!=null&&quick!=null)
        {
            if (slow==quick)
                return  slow;
            slow = slow.next;
            quick = quick.next;

            if (slow != quick)
                quick=quick.next;
        }
        return null;
    }
    static public ListNode EntryNodeOfLoop2(ListNode pHead)
    {
        ListNode meetingnode = FindMeetingnode(pHead);      //获取相遇节点
        if (meetingnode ==null)                             //相遇节点没有话，证明没有环
            return null;
        int nodesInloop = 1;                                //环节点数目
        ListNode p1 = meetingnode;
        while (p1.next!=meetingnode)                        //计算环节点数目
        {
            p1 = p1.next;
            ++nodesInloop;
        }
        p1 = pHead;
        for (int i = 0; i < nodesInloop; i++) {            //p1指针向前走环节点数目
            p1 =p1.next;
        }
        ListNode p2 = pHead;                                //p2指针为头结点
         while ( p1 !=p2)                                   //这时相遇时就是入口结点；
         {
             p1 =p1.next;
             p2 = p2.next;
         }
         return p1;
    }

}
