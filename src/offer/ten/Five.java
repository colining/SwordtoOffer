package offer.ten;

/**
 * Created by asus on 2017/3/17.
 */
import java.util.ArrayList;

public class Five {
    public  static  void  main(String [] arg)
    {

    }
    public class ListNode {
             int val;
             ListNode next = null;

             ListNode(int val) {
                this.val = val;
            }
         }

    public class Solution {
        ArrayList arrayList= new ArrayList();
        public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
            solution(listNode);                    //����ݹ�
            return arrayList;
        }
        void solution( ListNode listNode)          //�ݹ麯��
        {
            if (listNode!=null)             //��listcode����β�ڵ�ʱ
            {
                solution(listNode.next);           //�ݹ�
                arrayList.add(listNode.val);//��ӵ���������У������Ͳ��ᶪʧ��
            }

            return ;
        }
    }


}
