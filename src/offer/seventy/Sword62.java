package offer.seventy;

import Myjar.TreeNode;

/**
 * Created by colin on 2017/5/6.
 */
public class Sword62 {
    /* 二叉树序列化
    请实现两个函数，分别用来序列化和反序列化二叉树
     */
    String Serialize(TreeNode root) {
        StringBuilder builder = new StringBuilder();
        Serialize(root, builder);
        return builder.toString();
    }

    void Serialize(TreeNode root, StringBuilder builder) {
        if (root == null) {
            builder.append("$,");
            return;
        }
        //相当于前序遍历
        builder.append(root.val);
        builder.append(",");
        Serialize(root.left, builder);
        Serialize(root.right, builder);
    }

    int index = -1;

    TreeNode Deserialize(String str) {
        if (str == null || str.length() == 0)
            return null;
        String[] strings = str.split(",");
        return Deserialize(strings);
    }

    TreeNode Deserialize(String[] strs) {
        index++;
        if (!strs[index].equals("$")) {
            TreeNode root = new TreeNode(Integer.parseInt(strs[index]));
            root.left = Deserialize(strs);
            root.right = Deserialize(strs);
            return  root;
        }
        return null;
    }

}
