package offer.thirty;

import java.util.ArrayList;

/**
 * Created by asus on 2017/3/26.
 */
public class Five {
    public  static  void  main(String []arg)
    {
            TreeNode treeNode = new TreeNode(5);
        treeNode.left = new TreeNode(2);
        treeNode.right= new TreeNode(1);
        treeNode.right.left=new TreeNode(1);
        treeNode.left.left=new TreeNode(555);

    }
    ArrayList<ArrayList<Integer>> arrayLists= new ArrayList<>();
    ArrayList<Integer> list = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if ( root ==null)
            return arrayLists;
        target -=root.val;
        list.add(root.val);
        if (target==0&&root.left==null&&root.right==null)
        {
            arrayLists.add(new ArrayList<>(list));
        }
        FindPath(root.left,target);
        FindPath(root.right,target);
        list.remove(list.size()-1);
        return  arrayLists;
    }


}
