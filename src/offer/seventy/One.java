package offer.seventy;

import Myjar.TreeNode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by asus on 2017/5/4.
 */
public class One {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(5);
        node.right = new TreeNode(60);
        node.left = new TreeNode(70);
        node.left.left = new TreeNode(6);
        Print1(node);
    }

    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<>();
        if (pRoot == null)
            return arrayLists;
        ArrayList<Integer> arrayList = new ArrayList<>();
        LinkedList<TreeNode> linkedlist = new LinkedList();
        linkedlist.add(null);
        linkedlist.add(pRoot);
        boolean leftToright = true;
        while (linkedlist.size() != 1) {
            TreeNode node = linkedlist.removeFirst();
            if (node == null) {
                Iterator<TreeNode> iterator = null;
                if (leftToright) {
                    iterator = linkedlist.iterator();
                } else
                    iterator = linkedlist.descendingIterator();
                leftToright = !leftToright;
                while (iterator.hasNext()) {
                    TreeNode temp = iterator.next();
                    arrayList.add(temp.val);
                }
                arrayLists.add(new ArrayList<Integer>(arrayList));
                arrayList.clear();
                linkedlist.addLast(null);
                continue;
            }
            if (node.left != null) {
                linkedlist.addLast(node.left);
            }
            if (node.right != null) {
                linkedlist.addLast(node.right);
            }
        }
        return arrayLists;
    }

    public static ArrayList<ArrayList<Integer>> Print1(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<>();
        ArrayList<Integer> arrayList = new ArrayList<>();
        if (pRoot == null) {
            return arrayLists;
        }
        Stack<TreeNode> leftstack = new Stack<>();
        Stack<TreeNode> rightstack = new Stack<>();
        leftstack.add(pRoot);
        boolean left = true;
        while (leftstack.size() != 0 || rightstack.size() != 0) {
            TreeNode node = left ? leftstack.pop() : rightstack.pop();

            arrayList.add(node.val);
            if (left) {
                if (node.left != null) {
                    rightstack.add(node.left);

                }
                if (node.right != null)
                    rightstack.add(node.right);
            } else if (!left) {
                if (node.right != null)
                    leftstack.add(node.right);
                if (node.left != null)
                    leftstack.add(node.left);
            }
            if (left && leftstack.empty()) {
                arrayLists.add(new ArrayList<>(arrayList));
                arrayList.clear();
                left = false;
            } else if (!left && rightstack.empty()) {
                arrayLists.add(new ArrayList<>(arrayList));
                arrayList.clear();
                left = true;
            }
        }
        return arrayLists;
    }
}
