package offer.seventy;

import Myjar.TreeNode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by colin on 2017/5/4.
 */
public class Sword61 {
    /*  按之字形顺序打印二叉树
    从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
     */
    public static void main(String[] args) {
        TreeNode node = new TreeNode(5);
        node.right = new TreeNode(60);
        node.left = new TreeNode(70);
        node.left.left = new TreeNode(6);
        Print1(node);
    }

    public static ArrayList<ArrayList<Integer>> Print1(TreeNode pRoot) {
        /*
        思路：使用两个栈，加一个布尔变量确定使用那个栈，
        打印一个栈的结点的时候，就把它的子结点压入另一个栈
        两个栈的压入方式是相反的
         */
        ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<>();
        ArrayList<Integer> arrayList = new ArrayList<>();
        if (pRoot == null) {
            return arrayLists;
        }
        Stack<TreeNode> leftStack = new Stack<>();
        Stack<TreeNode> rightStack = new Stack<>();
        leftStack.add(pRoot);
        boolean left = true;
        while (leftStack.size() != 0 || rightStack.size() != 0) {
            TreeNode node = left ? leftStack.pop() : rightStack.pop();
            arrayList.add(node.val);
            if (left) {
                if (node.left != null) {
                    rightStack.add(node.left);
                }
                if (node.right != null)
                    rightStack.add(node.right);
            } else if (!left) {
                if (node.right != null)
                    leftStack.add(node.right);
                if (node.left != null)
                    leftStack.add(node.left);
            }
            if (left && leftStack.empty()) {
                arrayLists.add(new ArrayList<>(arrayList));
                arrayList.clear();
                left = false;
            } else if (!left && rightStack.empty()) {
                arrayLists.add(new ArrayList<>(arrayList));
                arrayList.clear();
                left = true;
            }
        }
        return arrayLists;
    }

    public ArrayList<ArrayList<Integer>> Print2(TreeNode pRoot) {
        /*
        通过引入null作为行结束标志，并使用Iterator进行前后遍历
         */
        ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<>();
        if (pRoot == null)
            return arrayLists;
        ArrayList<Integer> arrayList = new ArrayList<>();
        LinkedList<TreeNode> linkedList = new LinkedList();
        linkedList.add(null);
        linkedList.add(pRoot);
        boolean leftToRight = true;
        while (linkedList.size() != 1) {
            TreeNode node = linkedList.removeFirst();
            if (node == null) {
                Iterator<TreeNode> iterator = null;
                if (leftToRight) {
                    iterator = linkedList.iterator();
                } else
                    iterator = linkedList.descendingIterator();
                leftToRight = !leftToRight;
                while (iterator.hasNext()) {
                    TreeNode temp = iterator.next();
                    arrayList.add(temp.val);
                }
                arrayLists.add(new ArrayList<Integer>(arrayList));
                arrayList.clear();
                linkedList.addLast(null);
                continue;
            }
            if (node.left != null) {
                linkedList.addLast(node.left);
            }
            if (node.right != null) {
                linkedList.addLast(node.right);
            }
        }
        return arrayLists;
    }
}
