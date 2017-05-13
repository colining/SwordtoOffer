package offer.ten;

/**
 * Created by colin on 2017/3/16.
 */
public class Sword03 {
    /* 二维数组中的查找
    在一个二维数组中，每一行都按照从左到右递增的顺序排序，
    每一列都按照从上到下递增的顺序排序。请完成一个函数，
    输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
     */
    public static void main(String[] arg) {
        //int DoesTreeHaveTree[] []= {{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
        int a[][] = {{1, 2, 3, 9}, {2, 4, 9, 12}};
        //int DoesTreeHaveTree [][] = new int[2][2];
        int b = 3;
        System.out.println(Sword03.Find1(b, a));

    }

    public static boolean Find(int target, int[][] array) {
        /*
        类似于蛮力法
         */
        if (array == null || array.length < 1 || array[0].length < 1)
            return false;
        int Rows = array.length - 1;
        int Cols = array[0].length - 1;
        for (int col = Cols; col >= 0; col--) {
            if (target >= array[0][col]) {
                for (int row = 0; row <= Rows; row++) {
                    if (target == array[row][col])
                        return true;
                }
            }
        }
        return false;
    }

    public static boolean Find1(int target, int[][] array) {
        /*
        对每一行 二分查找
         */
        for (int i = 0; i < array.length; i++) {
            int low = 0;
            int high = array[0].length;
            while (low <= high) {
                int mid = (low + high) / 2;
                if (target > array[i][mid]) {
                    low = mid + 1;
                } else if (target < array[i][mid]) {
                    high = mid - 1;
                } else
                    return true;
            }
        }
        return false;
    }

    public static boolean Find2(int target, int[][] array) {
        if (array == null || array.length < 1 || array[0].length < 1)
            return false;
        int Rows = array.length - 1;
        int Cols = array[0].length - 1;
        int row = Rows;
        int col = 0;
        /*
        从左下脚开始搜寻，
         */
        while (row >= 0 && col <= Cols) {
            if (array[row][col] < target)                 //如果每行里最大的都小，那就移除这一列
                col++;
            else if (array[row][col] > target)            //因为是从每列最下面开始找，如果大的话，就直接移除整行
                row--;
            else if (array[row][col] == target)
                return true;
        }
        return false;
    }

}
