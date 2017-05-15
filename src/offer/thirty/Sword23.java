package offer.thirty;


import Myjar.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by colin on 2017/3/26.
 */
public class Sword23 {
    /* 从上往下打印二叉树
    从上往下打印出二叉树的每个结点，同层结点从左至右打印。
     */
    public static void main(String[] arg) {
        Sword23 sword23 = new Sword23();
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(2);
        root.right = new TreeNode(1);
        sword23.PrintFromTopToBottom(root);
    }

    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        if (root == null)
            return arrayList;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        /*
        利用队列，遍历到一个结点，就将其子结点放在队列中，然后队列按次序出队，
        自然就是层次遍历喽
         */
        while (!queue.isEmpty()) {
            TreeNode treeNode = queue.poll();
            if (treeNode.left != null) {
                queue.offer(treeNode.left);
            }
            if (treeNode.right != null) {
                queue.offer(treeNode.right);
            }
            arrayList.add(treeNode.val);
        }
        return arrayList;

    }

    /**
     * 先序遍历
     * <p>
     * 这三种不同的遍历结构都是一样的，只是先后顺序不一样而已
     *
     * @param node 遍历的结点
     */
    public static void preOrderTraverse(TreeNode node) {
        if (node == null)
            return;
        System.out.print(node.val + " ");
        preOrderTraverse(node.left);
        preOrderTraverse(node.right);
    }

    /**
     * 中序遍历
     * <p>
     * 这三种不同的遍历结构都是一样的，只是先后顺序不一样而已
     *
     * @param node 遍历的结点
     */
    public static void inOrderTraverse(TreeNode node) {
        if (node == null)
            return;
        inOrderTraverse(node.left);
        System.out.print(node.val + " ");
        inOrderTraverse(node.right);
    }

    /**
     * 后序遍历
     * <p>
     * 这三种不同的遍历结构都是一样的，只是先后顺序不一样而已
     *
     * @param node 遍历的结点
     */
    public static void postOrderTraverse(TreeNode node) {
        if (node == null)
            return;
        postOrderTraverse(node.left);
        postOrderTraverse(node.right);
        System.out.print(node.val + " ");
    }


}