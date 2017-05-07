package offer.ten;

/**
 * Created by asus on 2017/3/18.
 */
public class Six {

    public  static  void  main(String [] arg)
    {
        int a[] = {1,2,4,7,3,5,6,8};
        int b[] = {4,7,2,1,5,3,8,6};
        Six six = new Six();
        six.reConstructBinaryTree(a,b);
    }

  public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }


    //TreeNode treeNode=null;
        public  TreeNode reConstructBinaryTree(int [] pre,int [] in) {

            if (pre==null||in==null)
            {
                return null;
            }
           TreeNode root = test(pre,in);
            root.toString();
            return root;
        }
        public TreeNode test( int pre[],int in[] )
        {
            TreeNode treeNode1 = new TreeNode(pre[0]);
            int a[] = new  int[pre.length];
            int b[] = new  int[pre.length];
            int flag=0;
            for (int i = 0 ; i<in.length;i++)
            {
                if (in[i] == pre[0])
                {
                    flag=i;
                    break;
                }
            }
            if (flag!=0) {
                int left[] = new int[flag];
                System.arraycopy(in, 0, left, 0, flag);
                int leftpre[] = new int[flag];
                System.arraycopy(pre, 1, leftpre, 0, flag);
                treeNode1.left = test(leftpre,left);

            }
            if (flag!=pre.length-1) {
                int right[] = new int[pre.length-flag-1];
                System.arraycopy(in, flag+1,right, 0, in.length-(flag+1));
                int rightpre[] = new int[pre.length-flag-1];

                System.arraycopy(pre, flag+1, rightpre, 0, in.length-(flag+1));
                treeNode1.right =  test(rightpre,right);

            }
            return treeNode1;
        }
}
