package offer.fifty;

import static Myjar.Quicksort.quick_sort;

/**
 * Created by colin on 2017/4/5.
 */
public class Sword44 {
    /* 扑克牌顺子
    输入5个数，判断是否可以是一个顺子
     */
    public static void main(String[] arg) {
        int[] a = {0, 1, 6, 4, 5};
        // System.out.println(isContinuous2(a));
        System.out.println(1 >> 5);
    }

    public static boolean isContinuous1(int[] numbers) {
        if (numbers == null || numbers.length < 5)            //输入检测
            return false;
        int start = 0;
        int numberOfZero = 0;
        //对数组排序
        numbers = quick_sort(numbers, start, numbers.length - 1);

        //获取0,大小王的个数
        while (start < numbers.length) {
            if (numbers[start] == 0)
                numberOfZero++;
            start++;
        }
        start = numberOfZero;
        int end = numberOfZero + 1;
        int needZero = 0;
        //通过计算数组中相邻的差来得到需要的大小王数量
        while (end < numbers.length) {
            if (numbers[start] == numbers[end])
                return false;
            else
                needZero += numbers[end] - numbers[start] - 1;
            end++;
            start++;
        }
        return (needZero > numberOfZero) ? false : true;
    }

    public static boolean isContinuous2(int[] numbers) {
        if (numbers.length != 5)
            return false;
        int max = -1;
        int min = 14;
        int flag = 0;                               //利用位图来查重
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] < 0 || numbers[i] > 13)
                return false;
            if (numbers[i] == 0)
                continue;
            //如果有相同的值，那这时一位运算就会移动到该值的特征值上，就是为1的时候
            if (((flag >> numbers[i]) & 1) == 1)
                return false;
            flag |= 1 << numbers[i];
            max = numbers[i] > max ? numbers[i] : max;
            min = numbers[i] < min ? numbers[i] : min;
            if (max - min >= 5)
                return false;
        }
        return false;
    }
}

