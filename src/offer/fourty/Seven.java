package offer.fourty;


import java.util.Stack;

/**
 * Created by asus on 2017/4/2.
 */
public class Seven {
    public static class ListNode {
        public   int val;
        public ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }
    }
    public static  void  main(String []arg)
    {
        ListNode a = new ListNode(0);
        ListNode b = new ListNode(1);
        a.next = b;
        ListNode c = new ListNode(2);
        b.next= c;
        ListNode a1= new ListNode(00);
        a1.next = b;
        ListNode listNode = new ListNode(0);
        ListNode listNode1 = listNode;

        System.out.println(FindFirstCommonNode1(a, a1).val);

    }

   static public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
//       if (pHead1==null||pHead2==null)
//           return null;
       Stack<ListNode> stack= new Stack<>();
       Stack<ListNode> stack1 = new Stack<>();
       ListNode node = null;
       while (pHead1!=null)             //把链表一压栈
       {
           stack.push(pHead1);
           pHead1=pHead1.next;
       }
       while (pHead2!=null)               //把链表二压栈
       {
           stack1.push(pHead2);
           pHead2 = pHead2.next;
       }
       /*
       检查链表是否为空，栈顶是否相同
        */
       while (!stack.isEmpty()&&!stack1.isEmpty()&&stack.peek()==stack1.peek())
       {
           node=stack.peek();
           stack.pop();
           stack1.pop();
       }
        return  node;
    }

    static public ListNode FindFirstCommonNode1(ListNode pHead1, ListNode pHead2)
    {
        if (pHead1==null||pHead2 ==null)
            return  null;
        int length1 = 0 ;
        int length2 = 0;
        ListNode node1 = pHead1;
        ListNode node2 = pHead2;
        while (pHead1!=null)        //链表一长度
        {
            length1++;
            pHead1=pHead1.next;
        }
        while (pHead2!=null)          //链表二长度
        {
            length2++;
            pHead2=pHead2.next;
        }
        while (length1>length2)        //消除长度差异
        {
            node1=node1.next;
            length1--;
        }
        while (length2>length1)          //消除长度差异
        {
            node2 = node2.next;
            length2--;
        }
        while (node1!=null&&node2!=null)    //找公共点
        {
            if (node1==node2)
                break;
            node1=node1.next;
            node2 = node2.next;

        }


        return node1;
    }
    static public ListNode FindFirstCommonNode2(ListNode pHead1,ListNode pHead2)
    {
        ListNode node1 = pHead1;
        ListNode node2 = pHead2;
        while ( node1!=null)
        {
            /*
            简单来说，相当于链表一和链表二对一个node都遍历过，
            所以长度肯定是一样的
             */
            node1=(node1==null?pHead2:node1.next);
            node2=(node2==null?pHead1:node2.next);

        }
        return node1;
    }
}
