package offer.thirty;



import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by asus on 2017/3/26.
 */
public class Three {
    public static void main(String[] arg) {
        Three three = new Three();
        TreeNode root=new TreeNode(5);
        root.left=new TreeNode(2);
        root.right = new TreeNode(1);
        three.PrintFromTopToBottom(root);
    }



    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> arrayList= new ArrayList<>();
        if (root==null)
            return arrayList;
        TreeNode node = root;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty())
        {
            TreeNode treeNode = queue.poll();
            if (treeNode.left!=null)
            {
                queue.offer(treeNode.left);
            }
            if (treeNode.right!=null)
            {
                queue.offer(treeNode.right);
            }
            arrayList.add(treeNode.val);
        }
        return arrayList;

    }

    /**
     * 先序遍历
     *
     * 这三种不同的遍历结构都是一样的，只是先后顺序不一样而已
     *
     * @param node
     *            遍历的节点
     */
    public static void preOrderTraverse(TreeNode node) {
        if (node == null)
            return;
        System.out.print(node.val + " ");
        preOrderTraverse(node.left);
        preOrderTraverse(node.right);
    }

    /**
     * 中序遍历
     *
     * 这三种不同的遍历结构都是一样的，只是先后顺序不一样而已
     *
     * @param node
     *            遍历的节点
     */
    public static void inOrderTraverse(TreeNode node) {
        if (node == null)
            return;
        inOrderTraverse(node.left);
        System.out.print(node.val + " ");
        inOrderTraverse(node.right);
    }

    /**
     * 后序遍历
     *
     * 这三种不同的遍历结构都是一样的，只是先后顺序不一样而已
     *
     * @param node
     *            遍历的节点
     */
    public static void postOrderTraverse(TreeNode node) {
        if (node == null)
            return;
        postOrderTraverse(node.left);
        postOrderTraverse(node.right);
        System.out.print(node.val+ " ");
    }


}