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
    public TreeNode findLCABST(TreeNode root, TreeNode p, TreeNode q) {
        int a = p.val;
        int b = q.val;
        if (root != null) {
            if (root.val > a && root.val > b)
                findLCABST(root.left, p, q);
            else if (root.val < a && root.val < b)
                findLCABST(root.right, p, q);
            else
                return root;
        }
        return null;
    }

    /*
    一般二叉树，如果有父结点指针，就直接当成两个链表求公共结点，
    否则的话，我们记录一下根结点到达两个结点的路径，找寻公共结点
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
//        System.out.println(findLCABT1(treeNode, left.right, left.left.left).val);
        System.out.println(lowestCommonAncestor(treeNode, left.left.left, left.left));
        TreeNode test = new TreeNode(1);
        test.left = new TreeNode(2);
//        System.out.println(findLCABT1(test, test.left, test).val);
//        System.out.println(lowestCommonAncestor(test, test.left, test).val);
    }

    //解法一：路径链表
    public static TreeNode findLCABT1(TreeNode root, TreeNode p, TreeNode q) {
        ArrayList<TreeNode> path1 = new ArrayList<>();
        ArrayList<TreeNode> path2 = new ArrayList<>();
        //寻找结点一的路径
        findPath(root, p, path1);
        //寻找结点二的路径
        findPath(root, q, path2);
        //两个链表寻找公共结点的部分
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
        //寻找路径的递归结束
        if (head == null)
            return false;
        //将当前结点放在链表里
        path.add(head);
        //找到目标结点，就返回
        if (head == node)
            return true;
        //用if包围，只要找到一个，就直接返回，这样就不用全部遍历了
        if (findPath(head.left, node, path))
            return true;
        if (findPath(head.right, node, path))
            return true;
        path.remove(path.size() - 1);
        return false;

    }

    //解法二：自顶向下，用例通过 30/31，最后一个超时
    public static TreeNode findLCABT2(TreeNode root, TreeNode p, TreeNode q) {
        /*
        核心想法是这两个结点肯定是祖先的子结点，于是就从root开始寻找；root是祖先，
        然后寻找root的左结点是不是祖先，有右结点是不是祖先；
        最后我们找到，当前结点不是两个结点的祖先，那当前结点的父结点就是最低公共祖先了
         */
        if (hasNode(root.left, p) && hasNode(root.left, q))
            return findLCABT2(root.left, p, q);
        if (hasNode(root.right, p) && hasNode(root.right, q))
            return findLCABT2(root.right, p, q);
        return root;
    }

    public static boolean hasNode(TreeNode root, TreeNode node) {
        if (root == null)
            return false;
        if (root == node)
            return true;
        return (hasNode(root.left, node) || hasNode(root.right, node));
    }

    //解法三：自底向上，速度最快，
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        /*
        思路就是，自底向上走，后序遍历，先遍历最底下，如果有目标结点，在后序遍历后面，就层层向上标记，
        说明有结点在这个子树中，假设同时标记了两次，说明当前结点的子树恰好含有两个结点，这样就找到了最低公共祖先；
        在这道题中，left和right就相当于标记；由于每次找到结点就会返回，所以如果一个结点是另一个的父结点，不只有
        一个标记；
         */
        if (root == null) return null;
        if (root == p) return root;
        if (root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null) return right;
        if (right == null) return left;
        return root;
    }
}
