package offer.thirty;

/**
 * Created by asus on 2017/3/26.
 */
public class Seven {
    public static  void  main(String []arg)
    {

    }
    TreeNode head;
    TreeNode realhead;
    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree==null)
            return null;
        TreeNode node=pRootOfTree;

        if (node.left!=null)
        Convert(node.left);
        if (head==null)
        {
            head=pRootOfTree;
            realhead=pRootOfTree;
        }
        else
        {
            head.right=pRootOfTree;
            pRootOfTree.left=head;
            head = pRootOfTree;
        }
        if (node.right!=null)
        Convert(node.right);

        return  realhead;
    }
}
