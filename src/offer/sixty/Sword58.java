package offer.sixty;

/**
 * Created by colin on 2017/5/4.
 */

class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}

public class Sword58 {
    /* 二叉树的下一个结点
    给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
    注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
     */
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if (pNode == null)
            return null;
        TreeLinkNode node = pNode;
        /*
        右结点不为空，就在右子树里寻找最左面的结点
         */
        if (pNode.right != null) {
            node = node.right;
            while (node.left != null) {
                node = node.left;
            }
            return node;
        }
        /*
        右结点为空的情况下；下一个结点一定是父亲之类的；
        如果当前是父结点的左子结点，那么就是这个父结点了；
        否则就一直往上找，直到找到是当前结点是父结点的左子结点；
         */
        else if (pNode.next != null) {
            TreeLinkNode currentNode = pNode;
            TreeLinkNode parent = currentNode.next;
            while (parent != null && currentNode == parent.right) {
                currentNode = parent;
                parent = parent.next;
            }
            return parent;
        }
        return null;
    }
}