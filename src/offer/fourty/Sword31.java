package offer.fourty;

/**
 * Created by colin on 2017/3/30.
 */
public class Sword31 {
    /* 连续子数组的最大和
    输入一个数组，输出该数组中最大的 子数组和
     */
    public static void main(String[] arg) {
        int[] array = {-2, -8, -1, -5, -9};
        System.out.println(FindGreatestSumOfSubArray1(array));
    }

    static public int FindGreatestSumOfSubArray1(int[] array) {
        /*
        动态规划的方法
         */
        if (array == null || array.length == 0)
            return 0;
        int sum = array[0];             //最大子数组和，最终结果
        int tempSum = array[0];         //当前子数组的和
        for (int i = 1; i < array.length; i++) {
            tempSum = (tempSum < 0) ? array[i] : array[i] + tempSum;
            sum = (tempSum > sum) ? tempSum : sum;
        }
        return sum;
    }

    static public int FindGreatestSumOfSubArray2(int[] array) {
        /*
        其实想法和上面一样的
         */
        if (array == null || array.length == 0)
            return 0;
        int currentSum = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            if (currentSum <= 0)
                currentSum = array[i];
            else
                currentSum += array[i];

            if (currentSum > max)
                max = currentSum;
        }
        return max;
    }
}
