package offer.sixty;

import java.util.HashSet;

/**
 * Created by colin on 2017/4/9.
 */
public class Sword51 {
    /* 数组中重复的数字
    在一个长度为n的数组里的所有数字都在0到n-1的范围内。
    数组中某些数字是重复的，但不知道有几个数字是重复的。
    也不知道每个数字重复几次。请找出数组中任意一个重复的数字。
    例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，
    那么对应的输出是重复的数字2或者3。
     */
    public static void main(String[] args) {

    }

    //解法一：利用hashSet
    public boolean duplicate1(int numbers[], int length, int[] duplication) {
        //检查一下
        if (numbers == null || numbers.length == 0) {
            return false;
        }
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] < 0 || numbers[i] > numbers.length - 1)
                return false;
        }

        HashSet<Integer> hashSet = new HashSet();
        boolean flag = false;
        //使用hashset，如果hashset存在这个值，那么就重复了
        for (int i = 0; i < numbers.length; i++) {
            if (hashSet.contains(numbers[i])) {
                duplication[0] = numbers[i];
                flag = true;
            } else
                hashSet.add(numbers[i]);
        }
        return flag;
    }
    //解法二：数组特性
    public boolean duplicate2(int numbers[], int length, int[] duplication) {
        //检查一下
        if (numbers == null || numbers.length == 0) {
            return false;
        }
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] < 0 || numbers[i] > numbers.length - 1)
                return false;
        }

        for (int i = 0; i < numbers.length; i++) {
            //第i位置应该存放的就是i；如果不是，就把它放在number[i]那里
            while (numbers[i] != i) {
                //如果放过去，发现当前这个位置已经是正确的了，说明重复
                if (numbers[i] == numbers[numbers[i]]) {
                    duplication[0] = numbers[i];
                    return true;
                }
                int temp = numbers[i];
                numbers[i] = numbers[temp];
                numbers[temp] = temp;
            }
        }
        return false;
    }
}
