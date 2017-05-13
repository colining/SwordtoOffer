package offer.thirty;

import Myjar.TreeNode;

/**
 * Created by colin on 2017/3/26.
 */
public class Sword27 {
    /* 二叉搜索树与双向链表
    输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
    要求不能创建任何新的结点，只能调整树中结点指针的指向。
     */
    public static void main(String[] args) {
        TreeNode node = new TreeNode(4);
        node.left = new TreeNode(1);
        node.right = new TreeNode(2);
        Sword27 sword27 = new Sword27();
        sword27.Convert(node);
    }
    TreeNode current;
    TreeNode realhead;

    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null)
            return null;
        TreeNode node = pRootOfTree;

        if (node.left != null)
            Convert(node.left);
        /*
        current 实际是链表当前最后一个结点；
        因为是按照中序遍历，自然而然的就将
        二叉搜索树变为了链表
         */
        if (current == null) {
            current = pRootOfTree;
            realhead = pRootOfTree;
        } else {
            current.right = pRootOfTree;
            pRootOfTree.left = current;
            current = pRootOfTree;
        }
        if (node.right != null)
            Convert(node.right);

        return realhead;
    }
}
