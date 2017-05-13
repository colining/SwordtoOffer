package offer.thirty;

/**
 * Created by colin on 2017/3/27.
 */
public class Sword29 {
    /* 数组中出现次数超过一般的数字
    数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
    例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
    由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
     */
    public static void main(String[] arg) {
        int a[] = {1, 2, 3, 2, 2, 2, 5, 4, 2};
        int b[] = new int[1];
        System.out.println(MoreThanHalfNum_Solution1(a));
    }

    static public int MoreThanHalfNum_Solution(int[] array) {
        //检查输入的部分
        if (array == null || array.length <= 0)
            return 0;
        else if (array.length == 1)
            return array[0];
        //寻找中位数的部分
        int start = 0;
        int end = array.length - 1;
        int middle = array.length >> 1;
        int index = AdjustArray(array, start, end);
        //定位定位数
        while (index != middle) {
            if (index > middle) {
                end = index - 1;
                index = AdjustArray(array, start, end);
            } else {
                start = index + 1;
                index = AdjustArray(array, start, end);
            }
        }
        int number = array[middle];
        //验证次数的部分
        int times = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == number)
                times++;
        }
        if (times * 2 <= array.length)
            return 0;
        else
            return number;
    }

    public static int AdjustArray(int array[], int left, int right) {
        int x = array[left];
        while (left < right) {
            while (array[right] >= x && left < right)
                right--;
            if (left < right) {
                array[left] = array[right];
                left++;
            }

            while (array[left] < x && left < right)
                left++;
            if (left < right) {
                array[right] = array[left];
                right--;
            }
        }
        array[left] = x;
        return left;
    }

    public static int MoreThanHalfNum_Solution1(int array[]) {
        //输入检测
        if (array == null || array.length <= 0)
            return 0;
        else if (array.length == 1)
            return array[0];
        //寻找times保留下来的值
        int times = 1;
        int result = array[0];
        for (int i = 1; i < array.length; ++i) {
            if (times == 0) {                               //更换新的数字
                result = array[i];
                times = 1;
            } else if (array[i] == result) {                //遇到相同的数字，++；
                times++;
            } else                                          //遇到不同的了，--；
                times--;
        }
        //
        int number = result;
        int time = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == number)
                time++;
        }
        if (time * 2 <= array.length)
            return 0;
        else
            return number;
    }
}
