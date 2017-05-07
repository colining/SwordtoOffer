package offer.sixty;


import Myjar.TreeNode;

/**
 * Created by asus on 2017/5/4.
 */
public class Nine {
    boolean isSymmetrical(TreeNode pRoot)
    {
       return isSymmetrical(pRoot,pRoot);
    }

    public boolean isSymmetrical(TreeNode node1,TreeNode node2)
    {
        if (node1 == null && node2 == null)
            return true;
        else if (node1 == null && node2 == null )
            return false;
        else if (node1.val != node2.val)
            return false;

        return isSymmetrical(node1.left,node2.right)&&
                isSymmetrical(node1.right,node2.left);
    }
}
