package offer.twenty;

/**
 * Created by asus on 2017/3/22.
 */
public class Five {
    public  static  void  main (String [] arg)
    {
            ListNode listNode = new ListNode(1);
            listNode.next = new ListNode(2);
            listNode.next.next = new ListNode(3);
        System.out.println(FindKthToTail(listNode, 3));
    }


      static   public ListNode FindKthToTail(ListNode head,int k) {
          if (head==null||k<=0)
              return null;

          ListNode ahead = head;
          ListNode behind = head;
          for ( int i =0;i<k-1;i++)
          {
              if (ahead.next==null)
                  return null;
              ahead=ahead.next;

          }

          while (ahead.next!=null)
          {
              ahead=ahead.next;
              behind=behind.next;
          }
          return  behind;
      }

}
