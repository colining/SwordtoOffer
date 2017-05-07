package offer.seventy;

import Myjar.TreeNode;

/**
 * Created by asus on 2017/5/6.
 */
public class Three {
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
        Three three = new Three();
        System.out.println(three.KthNode(head, 0).val);
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
        k--;
        if (k == 0)
            node = pRoot;
        FindKthNode(pRoot.right);

    }
}
