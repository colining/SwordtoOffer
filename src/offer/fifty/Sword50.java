package offer.fifty;


import Myjar.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by colin on 2017/5/14.
 */
public class Sword50 {
    /*
        关于树中两个结点的最低公共祖先的几个题
     */


    /*
    有一棵无穷大的满二叉树，其结点按根结点一层一层地从左往右依次编号，
    根结点编号为1。现在有两个结点a，b。请设计一个算法，求出a和b点的最近公共祖先的编号。
    给定两个int a,b。为给定结点的编号。
    请返回a和b的最近公共祖先的编号。注意这里结点本身也可认为是其祖先。
     */
    public int getLCA1(int a, int b) {
        while (a != b) {
            if (a > b) {
                a >>= 1;
            } else
                b >>= 1;
        }
        return a;
    }

    public int getLCA2(int a, int b) {
        char[] chars1 = Integer.toBinaryString(a).toCharArray();
        char[] chars2 = Integer.toBinaryString(b).toCharArray();
        int i = 0;
        int sum = 0;
        while (i < chars1.length && i < chars2.length) {
            if (chars1[i] != chars2[i]) {
                break;
            }
            sum = sum * 2 + chars1[i] - '0';
            i++;
        }
        return sum;
    }

    /*
    二叉搜索树，寻找最低公共祖先，祖先一定比一个大，比另一个小
    oj https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/#/description
    */
    public TreeNode findLCA1(TreeNode root, TreeNode p, TreeNode q) {
        int a = p.val;
        int b = q.val;
        if (root != null) {
            if (root.val > a && root.val > b)
                findLCA1(root.left, p, q);
            else if (root.val < a && root.val < b)
                findLCA1(root.right, p, q);
            else
                return root;
        }
        return null;
    }

    /*
    一般二叉树，如果有父节点指针，就直接当成两个链表求公共结点，
    否则的话，我们记录一下根节点到达两个结点的路径，找寻公共结点
    oj：https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/#/description
     */
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(-1);
        TreeNode left = new TreeNode(0);
        TreeNode right = new TreeNode(3);
        treeNode.left = left;
        treeNode.right = right;
        left.right = new TreeNode(4);
        left.left = new TreeNode(-2);
        left.left.left = new TreeNode(8);
        //System.out.println(findLCA2(treeNode, left.right, left.left.left).val);
        TreeNode test = new TreeNode(1);
        test.left = new TreeNode(2);
        System.out.println(findLCA2(test, test.left, test).val);
    }

    public static TreeNode findLCA2(TreeNode root, TreeNode p, TreeNode q) {
        ArrayList<TreeNode> path1 = new ArrayList<>();
        ArrayList<TreeNode> path2 = new ArrayList<>();
        findPath(root, p, path1);
        findPath(root, q, path2);
        if (path1 == null || path2 == null || path1.size() == 0 || path2.size() == 0)
            return null;
        int i;
        for (i = 0; i < path1.size() && i < path2.size(); i++) {

            p = path1.get(i);
            q = path2.get(i);
            if (p != q)
                break;
        }
        return path1.get(i - 1);
    }


    public static boolean findPath(TreeNode head, TreeNode node, List<TreeNode> path) {
        if (head == null)
            return false;
        path.add(head);
        if (head == node)
            return true;
        if (findPath(head.left, node, path))
            return true;
        if (findPath(head.right, node, path))
            return true;
        path.remove(path.size() - 1);
        return false;

    }
}
