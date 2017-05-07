package offer.sixty;

import Myjar.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by asus on 2017/5/6.
 */
public class Ten {
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
        Queue<TreeNode> queue =new LinkedList<>();
        queue.add(pRoot);
        int nextlevel = 0;
        int changeline = 1;
        while (queue.size()>0)
        {
            TreeNode node = queue.poll();
            arrayList.add(node.val);
            if (node.left != null) {
                queue.add(node.left);
                nextlevel++;
            }
            if (node.right != null) {
                queue.add(node.right);
                nextlevel++;
            }
            changeline--;
            if (changeline==0)
            {
                arrayLists.add(new ArrayList<>(arrayList));
                arrayList.clear();
                changeline = nextlevel;
                nextlevel = 0;
            }
        }
        return arrayLists;
    }
}
