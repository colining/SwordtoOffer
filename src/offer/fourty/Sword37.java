package offer.fourty;


import Myjar.ListNode;

import java.util.Stack;

/**
 * Created by colin on 2017/4/2.
 */
public class Sword37 {
    /*  两个链表的公共结点
    输入两个链表，找出它们的第一个公共结点。
     */
    public static void main(String[] arg) {
        ListNode a = new ListNode(0);
        ListNode b = new ListNode(1);
        a.next = b;
        ListNode c = new ListNode(2);
        b.next = c;
        ListNode a1 = new ListNode(00);
        a1.next = b;
        ListNode listNode = new ListNode(0);
        ListNode listNode1 = listNode;

        System.out.println(FindFirstCommonNode1(a, a1).val);

    }

    static public ListNode FindFirstCommonNode1(ListNode pHead1, ListNode pHead2) {
        /*
          既然两个链表的长度差异阻碍了寻找，那我们就把长链表前面的部分忽略掉；
          为什么可以忽略掉呢？一位只要有公共结点，那么后面的链表就一定相同；
          因为结点只有一个指针
         */
        if (pHead1 == null || pHead2 == null)
            return null;
        int length1 = 0;
        int length2 = 0;
        ListNode node1 = pHead1;
        ListNode node2 = pHead2;
        while (pHead1 != null)        //链表一长度
        {
            length1++;
            pHead1 = pHead1.next;
        }
        while (pHead2 != null)          //链表二长度
        {
            length2++;
            pHead2 = pHead2.next;
        }
        while (length1 > length2)        //消除长度差异
        {
            node1 = node1.next;
            length1--;
        }
        while (length2 > length1)          //消除长度差异
        {
            node2 = node2.next;
            length2--;
        }
        while (node1 != null && node2 != null)    //找公共点
        {
            if (node1 == node2)
                break;
            node1 = node1.next;
            node2 = node2.next;

        }


        return node1;
    }

    static public ListNode FindFirstCommonNode3(ListNode pHead1, ListNode pHead2) {
        /*
        链表从后往前寻找，如果有公共结点，那么后面就一定是公共结点，然后往前寻找
        不一样的结点；就是它后面的啦
         */
       if (pHead1==null||pHead2==null)
           return null;
        Stack<ListNode> stack = new Stack<>();
        Stack<ListNode> stack1 = new Stack<>();
        ListNode node = null;
        while (pHead1 != null)             //把链表一压栈
        {
            stack.push(pHead1);
            pHead1 = pHead1.next;
        }
        while (pHead2 != null)               //把链表二压栈
        {
            stack1.push(pHead2);
            pHead2 = pHead2.next;
        }
       /*
       检查链表是否为空，栈顶是否相同
        */
        while (!stack.isEmpty() && !stack1.isEmpty() && stack.peek() == stack1.peek()) {
            node = stack.peek();
            stack.pop();
            stack1.pop();
        }
        return node;
    }

    static public ListNode FindFirstCommonNode2(ListNode pHead1, ListNode pHead2) {
        ListNode node1 = pHead1;
        ListNode node2 = pHead2;
        while (node1 != node2) {
            /*
                第一个公共结点之所以难判断是因为我们不知道两条链之前有多少个结点
                这个方法是说，一条链走完了，就从另一条链开始走，这样两个指针最后到达第一个公共结点
                所走过的路程就是相同的了；
                M:————|——
                N:    ——|——
                假设|为公共结点，该方法就是讲两个指针即走了M的前半部分，也走了N的前半部分，
                这样就同时到达公共结点了；
             */
            node1 = (node1 == null ? pHead2 : node1.next);
            node2 = (node2 == null ? pHead1 : node2.next);

        }
        return node1;
    }
}
