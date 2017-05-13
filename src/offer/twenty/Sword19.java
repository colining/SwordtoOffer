package offer.twenty;

import Myjar.TreeNode;

import java.util.Stack;

/**
 * Created by colin on 2017/3/25.
 */
public class Sword19 {
    /* 二叉树镜像
    操作给定的二叉树，将其变换为源二叉树的镜像。
    二叉树的镜像定义：源二叉树
    	    8
    	   /  \
    	  6   10
    	 / \  / \
    	5  7 9  11
    	镜像二叉树
    	    8
    	   /  \
    	  10   6
    	 / \  / \
    	11 9 7   5

     */
    public static void main(String[] arg) {

    }


    static public void Mirror(TreeNode root) {
        if (root == null)                                   //防止根节点为空
            return;
        if (root.left == null && root.right == null)       //防止他没有两个子节点；如果有一个也需要交换位置
            return;
        TreeNode node = root.left;                         //交换位置
        root.left = root.right;
        root.right = node;
        if (root.left != null)                              //递归左边
            Mirror(root.left);
        if (root.right != null)                             //递归右边
            Mirror(root.right);
    }

    static public void Mirror1(TreeNode treeNode) {
        /*
        非要把递归写成栈
         */
        Stack<TreeNode> stack = new Stack<>();
        stack.push(treeNode);
        while (!stack.empty()) {
            TreeNode node = stack.pop();
            if (node.left != null && node.right != null) {
                TreeNode temp = node.left;
                node.left = node.right;
                node.right = temp;
            }
            if (node.left != null)
                stack.push(node.left);
            if (node.right != null)
                stack.push(node.right);
        }
    }

}
