package offer.fourty;

/**
 * Created by asus on 2017/4/2.
 */
public class Nine {

     public class TreeNode {
     int val = 0;
     TreeNode left = null;
     TreeNode right = null;
     public TreeNode(int val) {
     this.val = val;

     }
     }


   static public int TreeDepth(TreeNode root) {
       if (root==null)
           return 0;
      int leftdepth  = TreeDepth(root.left);
      int rightdepth = TreeDepth(root.right);
       return leftdepth>rightdepth?leftdepth+1:rightdepth+1;
    }
    static  boolean flag = true;
    static public boolean IsBalanced(TreeNode root)
    {
        IsBalanced_Solution(root);
        return flag;
    }
   static public int IsBalanced_Solution(TreeNode root) {
        if (root == null)
            return 0;
       int leftdepth = IsBalanced_Solution(root.left);
       int rightdepth = IsBalanced_Solution(root.right);
       if (Math.abs(leftdepth-rightdepth)>1)
           flag=false;
       return 0;
    }

}
