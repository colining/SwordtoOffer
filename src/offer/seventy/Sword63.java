package offer.seventy;

import Myjar.TreeNode;

/**
 * Created by colin on 2017/5/6.
 */
public class Sword63 {
    /* 二叉搜索树的第k个结点
    给定一颗二叉搜索树，请找出其中的第k大的结点。
    例如， 5 / \ 3 7 /\ /\ 2 4 6 8 中，按结点数值大小顺序第三个结点的值为4。
     */
    public static void main(String[] args) {
        TreeNode head = new TreeNode(5);

        TreeNode left = new TreeNode(3);
        left.left = new TreeNode(2);
        left.right = new TreeNode(4);
        TreeNode right = new TreeNode(7);

        right.left = new TreeNode(6);
        right.right = new TreeNode(8);
        head.left = left;
        head.right = right;
        Sword63 sword63 = new Sword63();
        System.out.println(sword63.KthNode(head, 0).val);
    }

    TreeNode KthNode(TreeNode pRoot, int k) {
        if (pRoot == null || k == 0)
            return null;
        this.k = k;
        FindKthNode(pRoot);
        this.k = k;
        return node;
    }

    TreeNode node = null;
    int k;

    void FindKthNode(TreeNode pRoot) {
        if (pRoot == null)
            return;
        FindKthNode(pRoot.left);
        //中序遍历
        k--;
        if (k == 0)
            node = pRoot;
        FindKthNode(pRoot.right);

    }
}
