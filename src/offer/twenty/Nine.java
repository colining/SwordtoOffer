package offer.twenty;

import java.util.Stack;

/**
 * Created by asus on 2017/3/25.
 */
public class Nine {
    public  static  void  main(String []arg)
    {

    }



      static   public void Mirror(TreeNode root) {
            if (root==null)                 //防止根节点为空
                return;
           if (root.left==null&&root.right==null)           //防止他没有两个根节点；如果有一个也需要交换位置
                return;
          TreeNode node =root.left;                         //交换位置
          root.left=root.right;
          root.right=node;
          if (root.left!=null)                              //递归左边
              Mirror(root.left);
          if (root.right!=null)                             //递归右边
              Mirror(root.right);
        }

      static  public  void  Mirror1(TreeNode treeNode)
      {
          Stack<TreeNode> stack = new Stack<>();
          stack.push(treeNode);
          while (!stack.empty())
          {
              TreeNode node = stack.pop();
              if (node.left!=null&&node.right!=null) {
                  TreeNode temp = node.left;
                  node.left=node.right;
                  node.right=temp;
              }
              if (node.left!=null)
                  stack.push(node.left);
              if (node.right!=null)
                  stack.push(node.right);
          }
      }

}
