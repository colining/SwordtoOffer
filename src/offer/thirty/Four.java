package offer.thirty;

/**
 * Created by asus on 2017/3/26.
 */
public class Four {
    public static void main(String[] arg) {
        int[] a = {5,7,6,9,11,10,8};
        //System.out.println(DoesTreeHaveTree.length);
        System.out.println(VerifySquenceOfBST1(a));
    }

    static public boolean VerifySquenceOfBST1(int[] sequence) {
        /*
        循环的做法，利用的是二叉搜索树中一个点，左边都比他小，右边都比他大；
        对于后序遍历，先遍历子节点，左子节点上的都小，右子节点都大，最后再遍历当前节点；
        对数组来说，前面一部分都比当前节点小，后面一部分都比当前节点大；小的部分不只是子节点，
        也可能是同一层左边的部分；
         */
        int size = sequence.length;
        if (size == 0)
            return false;
        int i = 0;
        while (--size >= 0) {
            while (sequence[i++] < sequence[size]) ;
            while (i < size && sequence[i++] > sequence[size]) ;
            if (i < size)
                return false;
            i = 0;
        }
        return true;
    }

    static public boolean VerifySquenceOfBST2(int[] sequence) {
        /*
        比较容易理解的递归做法，每次递归都可以看成一个全新的树，一边小，一边大；
        对数组来说，前面的小，后面的大；
        不会出现同一层，都是子节点的比较
         */
        if (sequence == null || sequence.length <= 0)
            return false;
        boolean flag = false;
        int i = 0, j;
        for (; i < sequence.length - 1; i++) {
            if (sequence[i] > sequence[sequence.length - 1])
                break;
        }
        for (j = i; j < sequence.length - 1; j++) {
            if (sequence[j] < sequence[sequence.length - 1])
                return false;
        }
        boolean left = true;
        if (i > 0) {
            int leftarray[] = new int[i];
            System.arraycopy(sequence, 0, leftarray, 0, i);
            left = VerifySquenceOfBST2(leftarray);
        }
        boolean right = true;
        if (i < sequence.length - 1) {
            int rightarray[] = new int[sequence.length - i - 1];
            System.arraycopy(sequence, 0, rightarray, 0, sequence.length - i - 1);
            right = VerifySquenceOfBST2(rightarray);
        }
        return left && right;
    }

}
