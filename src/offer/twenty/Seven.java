package offer.twenty;

import Myjar.ListNode;

/**
 * Created by asus on 2017/3/22.
 */
public class Seven {
    public static  void  main (String [] arg)
    {

    }


    public ListNode Merge(ListNode list1, ListNode list2) {
        if (list1==null)
            return list2;
       else if (list2==null)
            return list1;
        ListNode node = null;
        if (list1.val<list2.val)
        {
            node=list1;
            node.next= Merge(list1.next,list2);
        }
        else
        {
            node=list2;
            node.next = Merge(list1,list2.next);
        }
        return node;
    }
}
