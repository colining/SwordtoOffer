package offer.fourty;

import Myjar.TreeNode;

/**
 * Created by colin on 2017/4/2.
 */
public class Sword39 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);
        System.out.println(isBalanced(root));
    }

    public static   boolean isBalanced(TreeNode root) {
        maxDepth(root, 0);
//        maxDepth(root);
        return flag;
    }

    private static int maxDepth(TreeNode root) {
        if (root == null) {
            return -1;
        }
        int d1 = maxDepth(root.left);
        int d2 = maxDepth(root.right);
        if (Math.abs(d1 - d2) > 1) {
            flag = false;
        }
        return 1 + Math.max(d1, d2);
    }

    public static boolean flag = true;
    public static int maxDepth(TreeNode root,int d) {
        if (root == null) {
            return d;
        }
        d++;
        int d2 = maxDepth(root.left, d);
        int d3 = maxDepth(root.right, d);

        if (Math.abs(d2 - d3) > 1) {
            flag = false;
        }
        return Math.max(d2, d3);
    }
}
