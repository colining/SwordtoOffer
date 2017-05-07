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
            solution(listNode);                    //进入递归
            return arrayList;
        }
        void solution( ListNode listNode)          //递归函数
        {
            if (listNode!=null)             //当listcode不是尾节点时
            {
                solution(listNode.next);           //递归
                arrayList.add(listNode.val);//添加到类的属性中，这样就不会丢失了
            }

            return ;
        }
    }


}
