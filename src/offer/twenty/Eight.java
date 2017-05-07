package offer.twenty;

/**
 * Created by asus on 2017/3/22.
 */
public class Eight {




       static public boolean HasSubtree(TreeNode root1,TreeNode root2) {
           boolean result = false;
           if (root1!=null&&root2!=null)
           {
               if (root1.val==root2.val)
               {
                   result = a(root1,root2);
               }
               if (!result)
               {
                   result = HasSubtree(root1.left,root2);
               }
               if (!result)
               {
                   result = HasSubtree(root1.right,root2);
               }
           }
           return  result;

        }

        static  public boolean a(TreeNode root1,TreeNode root2)
        {
            if (root2==null)
                return true;
            if (root1==null)
                return  false;
            if (root1.val!=root2.val)
                return  false;
            return a(root1.left,root2)&&a(root1.right,root2);

        }

}
