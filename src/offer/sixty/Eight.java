package offer.sixty;

/**
 * Created by asus on 2017/5/4.
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

public class Eight {

    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if (pNode==null)
            return null;
        TreeLinkNode node = pNode;
        /*
        右节点不为空，就在右子树里寻找最左面的节点
         */
        if (pNode.right != null)
        {
            node = node.right;
            while (node.left!=null)
            {
                node = node.left;
            }
            return  node;
        }
        /*
        右节点为空的情况下；下一个节点一定是父亲之类的；
        如果当前是父节点的左子节点，那么就是这个父节点了；
        否则就一直往上找，直到找到是当前节点是父节点的左子节点；
         */
        else if (pNode.next!=null)
        {
            TreeLinkNode currentnode = pNode;
            TreeLinkNode parent = currentnode.next;
            while (parent != null && currentnode == parent.right)
            {
                currentnode = parent;
                parent = parent.next;
            }
            return  parent;
        }
        return null;
    }
}