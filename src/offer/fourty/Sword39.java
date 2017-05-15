package offer.fourty;

import Myjar.TreeNode;

/**
 * Created by colin on 2017/4/2.
 */
public class Sword39 {
    /* 二叉树的深度
    输入一棵二叉树，求该树的深度。
    从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，
    最长路径的长度为树的深度。
     */
    public static void main(String[] args) {

    }


    static public int TreeDepth(TreeNode root) {
        if (root == null)
            return 0;
        int leftDepth = TreeDepth(root.left);
        int rightDepth = TreeDepth(root.right);
        return leftDepth > rightDepth ? leftDepth + 1 : rightDepth + 1;
    }

    //二叉树是否平衡
    static boolean flag = true;

    //解法一
    static public boolean IsBalanced1(TreeNode root) {
        IsBalanced_Solution1(root);
        return flag;
    }

    static public int IsBalanced_Solution1(TreeNode root) {
        if (root == null)
            return 0;

        int leftDepth = IsBalanced_Solution1(root.left);
        int rightDepth = IsBalanced_Solution1(root.right);
        //你会发现每次都要进行比较操作；但实际上最低层的结点如果不平衡
        //就没有比较的必要了
        if (Math.abs(leftDepth - rightDepth) > 1)
            flag = false;
        return 0;
    }


    //解法二
    public boolean IsBalanced_Solution2(TreeNode root) {
        int depth = 0;
        return IsBalanced_Solution2(root, depth);
    }

    public boolean IsBalanced_Solution2(TreeNode root, int depth) {
        if (root == null) {
            depth = 0;
            return true;
        }
        int left = 0, right = 0;
        //使用if将递归包围起来，这样底层如果就不平衡了，上层就不做比较的操作了，直接返回了
        if (IsBalanced_Solution2(root.left, left) && IsBalanced_Solution2(root.right, right)) {
            int diff = left - right;
            if (diff <= 1 && diff >= -1) {
                depth = 1 + (left > right ? left : right);
                return true;
            }
        }
        return false;
    }

}
