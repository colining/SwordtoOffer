package offer.thirty;

import java.util.Arrays;

/**
 * Created by asus on 2017/3/27.
 */
public class QuickSort {
    /*
    快排
     */
    public static void main(String[] arg) {
        int a[] = {2, 3, 5, 8, 2, 5, 0, 9};
        System.out.println(Arrays.toString(quickSort1(a, 0, a.length - 1)));
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

    public static int[] quickSort(int array[], int left, int right) {
        if (left < right) {
            int mid = AdjustArray(array, left, right);
            quickSort(array, left, mid - 1);
            quickSort(array, mid + 1, right);
        }
        return array;
    }

    public static int[] quickSort1(int array[], int left, int right) {
        if (left < right) {
            //左右指针的备份，与哨兵x；
            int leftBack = left;
            int rightBack = right;
            int x = array[leftBack];
            while (left < right) {
                //从右向左找到一个小于哨兵的值，然后扔到前面去，此时右指针还指向当前这个值，
                //因为当前这个值小于哨兵，所以一定会被某个值取代
                while (array[right] >= x && left < right) {
                    right--;
                }
                if (left < right) {
                    array[left] = array[right];
                    left++;
                }
                //从左向右找到大于哨兵的值
                while (array[left] < x && left < right) {
                    left++;
                }
                if (left < right) {
                    array[right] = array[left];
                    right--;
                }
            }
            //将哨兵补到最后剩余的位置，这就是它最后的位置，左面比它小，右面比它大
            array[left] = x;
            //进入递归，哨兵已然在正确的位置，所以不用对它排序了；
            quickSort1(array, leftBack, left - 1);
            quickSort1(array, left + 1, rightBack);
        }
        return array;
    }

}
