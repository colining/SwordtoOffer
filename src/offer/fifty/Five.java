package offer.fifty;

import java.util.LinkedList;

public class Five {

    public  static  void  main(String []arg) {
        System.out.println(LastRemaining_Solution2(5, 3));
    }
    /*
    循环链表
     */
    static public int LastRemaining_Solution(int n, int m) {
        if (n==0) {
            return -1;
        }
        ListNode node = new ListNode(0);
        ListNode head = node;
        for (int i = 1; i < n; i++) {
            node.next = new ListNode(i);
            node=node.next;
        }
        node.next = head;
        int current = 1;
        ListNode start = head;      //当前报数的这个人
        ListNode back =  head;      //当前报数的前一个；
        while (start!=start.next)
        {
            while (current<m)
            {
                back = start;
                start=start.next;
                current++;
            }
            back.next = start.next;     //相当于从循环中扔了出去；
            start = back.next;
            current = 1;
        }
        return  start.val;
    }
    static public int LastRemaining_Solution2(int n , int m) {
        LinkedList<Integer> linkedList = new LinkedList();
        for (int i = 0; i < n; i++) {
            linkedList.add(i);
        }
        int current = 0;            //当前报数（0~m-1）
        int index = 0;              //当前位置的索引
        while (linkedList.size()>1)
        {
//            while (current<m-1)
//            {
//                index++;
//                index %=linkedList.size();
//                current++;
//            }
//            linkedList.remove(index);
//            current=0;
            index = (index+m-1)%linkedList.size();
            linkedList.remove(index);
        }
        return linkedList.peek();
    }
    /*
    公式
     */
    static public int LastRemaining_Solution1(int n, int m)
    {
        if ( n<1||m<1)
            return  -1;
        int last = 0;
        for (int i = 2;i<= n ; i++)
        {
            last = (last+m)%i;
        }
        return last;
    }
}

class ListNode {
    public int val;
    public ListNode next = null;
    public ListNode(int val) {
        this.val = val;
    }
}
