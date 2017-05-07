package offer.thirty;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by asus on 2017/3/26.
 */
public class Six {

public static class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}
    public  static  void  main(String []arg)
    {
        RandomListNode randomListNode= new RandomListNode(555);
        randomListNode.next=new RandomListNode(444);
        randomListNode.next.next=new RandomListNode(333);
        randomListNode.random=randomListNode.next.next;
        mapclone(randomListNode);

    }

    static public RandomListNode Clone(RandomListNode pHead)
    {
        if (pHead==null)
            return null;
        clone(pHead);
        connect(pHead);

        return reconnect(pHead);
    }

    static  public  void clone(RandomListNode head)     //在每一个节点后面加一个克隆节点
    {
        RandomListNode node = head;
        while (node!=null)
        {
            RandomListNode clone = new RandomListNode(node.label);  //克隆结点
            clone.next=node.next;
            clone.random=null;

            node.next=clone;                                        //node.next指向克隆结点
            node=clone.next;                                        //下一个结点
        }
    }

    static  public  void  connect(RandomListNode head)
    {
        RandomListNode node = head;
        while (node!=null)
        {
            if (node.random!=null)                  //random的复制
            {
                node.next.random = node.random;
            }
                node = node.next.next;

        }
    }
    static  public  RandomListNode  reconnect(RandomListNode head)
    {
        RandomListNode clonehead = head.next;           //保留一下克隆结点的头结点

        RandomListNode clone = head;
        RandomListNode node=head;
        /*
        进行结点分离
         */
        if (node!=null)
        {
            clone = node.next;
            node.next=clone.next;
            node = node.next;
        }
        while (node!=null)
        {
            clone.next = node.next;
            clone = clone.next;
            node.next =clone.next;
            node = node.next;
        }

        return clonehead;
    }

    static public RandomListNode mapclone(RandomListNode pHead)
    {
        if (pHead ==null)
            return  null;
        Map<RandomListNode,RandomListNode> m=new HashMap<>();               //建立hashmap
        RandomListNode head1 = pHead;                                       //head1是原表结点
        RandomListNode head2 = new RandomListNode(head1.label);             //head2是新表结点
        RandomListNode newhead = head2;                                     //保留一下新表的头结点
        m.put(head1,head2);                                                 //建立hash映射

        while (head1!=null)
        {
            if (head1.next!=null)
                head2.next = new RandomListNode(head1.next.label);          //复制结点
            else
                head2.next = null;
            head1 = head1.next;                                             //向后移动
            head2 = head2.next;
            m.put(head1,head2);                                             //放进hash表
        }
        head1 = pHead;
        head2 = newhead;
        while (head1!=null)
        {
            head2.random =m.get(head1.random);                              //通过hash表查询random
            head1 = head1.next;
            head2 = head2.next;
        }
        return  newhead;


    }
}
