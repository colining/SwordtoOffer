package offer.twenty;

import Myjar.TreeNode;

/**
 * Created by asus on 2017/3/22.
 */
public class Sword18 {
    static public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        boolean result = false;
        if (root1 != null && root2 != null) {
            //节点值相同，就可以进行子树比较，否则就继续找相同的节点
            if (root1.val == root2.val) {
                result = DoesTreeHaveTree(root1, root2);
            }
            /*
            这里相当于在遍历只不过是前序遍历，从先遍历的节点进行比较
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
        判断在头结点相同的两个子树，他们的其他子树是否相等
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
