package offer.twenty;

import Myjar.TreeNode;

/**
 * Created by colin on 2017/3/22.
 */
public class Sword18 {
    /* 树的子结构
    输入两棵二叉树A，B，判断B是不是A的子结构。
    （ps：我们约定空树不是任意一个树的子结构）
     */
    static public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        boolean result = false;
        if (root1 != null && root2 != null) {
            //结点值相同，就可以进行子树比较，否则就继续找相同的结点
            if (root1.val == root2.val) {
                result = DoesTreeHaveTree(root1, root2);
            }
            /*
            这里相当于在遍历只不过是前序遍历，从先遍历的结点进行比较
             */
            if (!result) {
                result = HasSubtree(root1.left, root2);
            }
            if (!result) {
                result = HasSubtree(root1.right, root2);
            }
        }
        return result;

    }

    static public boolean DoesTreeHaveTree(TreeNode root1, TreeNode root2) {
        /*
        判断在头结点相同的两个子树，它们的其它子树是否相等
         */
        if (root2 == null)
            return true;
        if (root1 == null)
            return false;
        if (root1.val != root2.val)
            return false;
        return DoesTreeHaveTree(root1.left, root2) && DoesTreeHaveTree(root1.right, root2);

    }

}
