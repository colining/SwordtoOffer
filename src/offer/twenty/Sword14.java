package offer.twenty;

import java.util.Arrays;

/**
 * Created by asus on 2017/3/22.
 */
public class Sword14 {
    public static void main(String[] arg) {
        int[] a = new int[]{1, 2, 3, 4, 5, 6, 7};
        reOrderArray(a);
    }

    static public void reOrderArray(int[] array1) {             //头尾指针
        /*
        该方法不考虑原来的顺序的
         */
        int array[] = array1;
        int leftindex = 0;
        int rightindex = array.length - 1;
        while (leftindex <= rightindex) {
            //有指针找到一个奇数停下，等着偶数换位置
            while ((array[rightindex] & 1) == 0) {
                rightindex--;
                if (rightindex <= leftindex)
                    break;
            }

            if ((array[leftindex] & 1) == 0) {
                //交换位置，有指针可以继续向前走了
                int k = array[leftindex];
                array[leftindex] = array[rightindex];
                array[rightindex] = k;
                rightindex--;
            }
            //不管找没找到，左指针都向左移动
            leftindex++;
        }
        System.out.println(Arrays.toString(array));

    }

    static public void reOrderArray1(int[] array)    //相邻交换
    {
        if (array == null || array.length == 0)
            return;
        int k = 0;
        for (int i = 0; i < array.length - 1; i++)
            for (int j = 0; j < array.length - 1; j++) {
                if ((array[j] & 1) == 0 && (array[j + 1] & 1) == 1) //如果相邻元素一奇一偶就调换位置
                {
                    k = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = k;
                }
            }

    }

    static public void reOrderArray2(int[] array)    //开辟数组
    {
        if (array == null || array.length == 0)
            return;
        /*
        偶数放一块，奇数放另外的地方
         */
        int test[] = new int[array.length];
        int j = 0;
        for (int i = 0; i < array.length; i++)         //先倒腾奇数
            if ((array[i] & 1) == 1)
                test[j++] = array[i];
        for (int i = 0; i < array.length; i++)         //在倒腾偶数
            if ((array[i] & 1) == 0)
                test[j++] = array[i];
        System.arraycopy(test, 0, array, 0, array.length);
        //System.out.println(Arrays.toString(array));

    }

    public static void reOrderArray3(int[] array) {
        if (array == null || array.length == 0)
            return;
        /*
        两个奇数之间的都是偶数或者是空，所以可以一次向前移动将偶数扔在后面
         */
        int i = 0, j;
        while (i < array.length) {
            //i找到一个奇数
            while (i < array.length && !isEven(array[i]))
                i++;
            //j从i+1开始寻找偶数
            j = i + 1;
            while (j < array.length && isEven(array[j]))
                j++;
            //此时j找到了另一个奇数

            if (j < array.length) {
                int tmp = array[j];
                /*
                将两个奇数中的偶数向后移动
                 */
                for (int j2 = j - 1; j2 >= i; j2--) {
                    array[j2 + 1] = array[j2];
                }
                array[i++] = tmp;
            } else {// 查找失敗
                break;
            }
        }
        System.out.println(Arrays.toString(array));
    }

    static boolean isEven(int n) {
        if ((n & 1) == 0)
            return true;
        return false;
    }

    public static void reOrderArray4(int[] array) {
        /*
        我们来想一下插排，遇到第一个奇数停下，那么前面就都是偶数。
        对这个奇数要做的就是将自己往前移就好了
         */

        for (int oddIndex = 0; oddIndex < array.length; oddIndex++) {
            int evenIndex;
            if ((array[oddIndex] & 1) == 1) {
                evenIndex = oddIndex - 1;
                int temp = array[oddIndex];
                while (evenIndex >= 0 && (array[evenIndex] & 1) == 0)               //插排中，直到前面没有偶数就停下来
                {                                                   //其实也就等于把那些元素全部向后移动了
                    array[evenIndex + 1] = array[evenIndex];
                    evenIndex--;
                }
                array[evenIndex + 1] = temp;
            }
        }
        System.out.println(Arrays.toString(array));
    }

}
