package offer.twenty;

/**
 * Created by asus on 2017/3/22.
 */
public class Six {
    public  static  void  main(String [] arg)
    {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        ReverseList1(listNode);
    }

      static   public ListNode ReverseList(ListNode head) {

          ListNode currentnode = head;
          ListNode prev =null;
          ListNode result=null;
          while (currentnode!=null)
          {
              ListNode next = currentnode.next;
              if (next ==null)
                  result = currentnode;

              currentnode.next=prev;
              prev=currentnode;
              currentnode=next;
          }
          return  result;
        }
      static   public ListNode ReverseList1(ListNode head)
      {
          if (head==null||head.next==null)
              return head;
          ListNode node = ReverseList1(head.next);

          head.next.next=head;
          head=null;

          return node;
      }
}
