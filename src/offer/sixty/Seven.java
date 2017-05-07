package offer.sixty;

/**
 * Created by asus on 2017/4/10.
 */
public class Seven {
    public static void main(String[] arg) {
        int[] a = {1, 1, 2, 2, 3, 4, 4, 5};
        ListNode node = new ListNode(a[0]);
        ListNode head = node;
        for (int i = 1; i < a.length; i++) {
            node.next = new ListNode(a[i]);
            node = node.next;
        }
        ListNode node1 = (deleteDuplication(head));
        while (node1 != null) {
            System.out.println(node1.val);
            node1 = node1.next;
        }
    }

    static public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    static public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null)
            return null;
        if (pHead.next==null)
            return pHead;
        ListNode node = new ListNode(0);
        node.next = pHead;
        ListNode pre = node;
        while (pHead != null && pHead.next != null) {
            ListNode next = pHead.next;     //下一个结点
            if (pHead.val == next.val)        //相同就后移
            {
                while (next != null && pHead.val == next.val) {
                    next = next.next;
                }
                pre.next = next;
                pHead = next;
            } else {
                pre = pHead;
                pHead = pHead.next;
            }

        }
        return node.next;
    }
}

