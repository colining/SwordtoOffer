package offer.sixty;

import Myjar.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by asus on 2017/5/6.
 */
public class Sword60 {
    /* 把二叉树打印成多行
    请实现一个函数按照之字形打印二叉树，
    即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，
    第三行按照从左到右的顺序打印，其它行以此类推。
     */
    public static void main(String[] args) {
        TreeNode node = new TreeNode(5);
        node.right = new TreeNode(60);
        node.left = new TreeNode(70);
        node.left.left = new TreeNode(6);
        Print(node);
    }

    public static ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<>();
        ArrayList<Integer> arrayList = new ArrayList<>();
        if (pRoot == null)
            return arrayLists;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(pRoot);
        int nextLevel = 0;              //下一行有多少结点
        int changeLine = 1;             //还没有打印的结点数，为0就换行
        while (queue.size() > 0) {
            TreeNode node = queue.poll();
            arrayList.add(node.val);
            if (node.left != null) {
                queue.add(node.left);
                nextLevel++;
            }
            if (node.right != null) {
                queue.add(node.right);
                nextLevel++;
            }
            changeLine--;
            if (changeLine == 0) {
                arrayLists.add(new ArrayList<>(arrayList));
                arrayList.clear();
                changeLine = nextLevel;
                nextLevel = 0;
            }
        }
        return arrayLists;
    }
}
