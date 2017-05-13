package offer.thirty;

import Myjar.TreeNode;

import java.util.ArrayList;

/**
 * Created by colin on 2017/3/26.
 */
public class Sword25 {
    /* 二叉树中和为某一值得路径
    输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
    路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
     */
    ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<>();
    ArrayList<Integer> list = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        /*
        寻找路径其实就是遍历，顺带的加上判定；
        这个判定是什么呢？就是从上到下的一条路径和正好和给定值相等；
        并且左右节点相等；递归结束条件是走到尽头，节点 == null；
        然后因为是通过list保存的，就需要进行删除，添加操作；
         */
        if (root == null)
            return arrayLists;
        target -= root.val;
        list.add(root.val);
        /*
        判定当前路径是否需要输出
         */
        if (target == 0 && root.left == null && root.right == null) {
            arrayLists.add(new ArrayList<>(list));
        }
        FindPath(root.left, target);
        FindPath(root.right, target);
        list.remove(list.size() - 1);
        return arrayLists;
    }
}
