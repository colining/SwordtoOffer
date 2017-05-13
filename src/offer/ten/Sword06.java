package offer.ten;

import Myjar.TreeNode;

/**
 * Created by colin on 2017/3/18.
 */
public class Sword06 {
    /*重建二叉树
    输入某二叉树的前序遍历和中序遍历的结果，
    请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
    例如输入前序遍历序列{1,2,4,7,3,5,6,8}和
    中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
     */
    public static void main(String[] arg) {
        int[] a = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] b = {4, 7, 2, 1, 5, 3, 8, 6};
        int[] a1 = {1, 2, 3};
        int[] b1 = {2, 1, 3};
        Sword06 sword06 = new Sword06();
        sword06.reConstructBinaryTree(a, b);
    }

    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {

        if (pre == null || in == null || pre.length != in.length) {
            return null;
        }
        //TreeNode root = test(pre, in);
        TreeNode root = test2(pre, in, 0, pre.length - 1, 0, in.length - 1);
        System.out.println(root.toString());
        return root;
    }

    public TreeNode test(int pre[], int in[]) {
        /*
        这个解法是我自己写的，好烂
        想法呢，就是先序遍历确定当前头结点，中序遍历，确定左右，然后递归就行了
         */
        TreeNode treeNode1 = new TreeNode(pre[0]);
        int flag = 0;
        for (int i = 0; i < in.length; i++) {
            if (in[i] == pre[0]) {
                flag = i;
                break;
            }
        }
        if (flag != 0) {
            int left[] = new int[flag];
            System.arraycopy(in, 0, left, 0, flag);
            int leftpre[] = new int[flag];
            System.arraycopy(pre, 1, leftpre, 0, flag);
            treeNode1.left = test(leftpre, left);
        }
        if (flag != pre.length - 1) {
            int right[] = new int[pre.length - flag - 1];
            System.arraycopy(in, flag + 1, right, 0, in.length - (flag + 1));
            int rightpre[] = new int[pre.length - flag - 1];
            System.arraycopy(pre, flag + 1, rightpre, 0, in.length - (flag + 1));
            treeNode1.right = test(rightpre, right);
        }
        return treeNode1;
    }

    public TreeNode test2(int pre[], int in[], int preleft, int preright, int inleft, int inright) {
        /*
        大神的写法
         */
        /*
        递归结束条件
         */
        if (preleft > preright || inleft > inright)
            return null;
        TreeNode treeNode = new TreeNode(pre[preleft]);
        /*
        递归
         */
        for (int index = inleft; index <= inright; index++) {
            if (in[index] == pre[preleft]) {                                //递归条件
                int leftlength = index - inleft;
                treeNode.left = test2(pre, in, preleft + 1, preleft + leftlength, inleft, index - 1);
                treeNode.right = test2(pre, in, preleft + leftlength + 1, preright, index + 1, inright);
                break;
            }
        }
        return treeNode;
    }

}
