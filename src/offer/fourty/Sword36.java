package offer.fourty;

import java.util.Arrays;

/**
 * Created by colin on 2017/4/1.
 */
public class Sword36 {
    /* 数组的逆序对
    在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
    输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。 即输出P%1000000007
     */
    public static void main(String[] arg) {
        int a[] = {364, 637, 341, 406, 747, 995, 234, 971, 571, 219, 993, 407, 416, 366, 315, 301, 601, 650, 418, 355, 460, 505, 360, 965, 516, 648, 727, 667, 465, 849, 455, 181, 486, 149, 588, 233, 144, 174, 557, 67, 746, 550, 474, 162, 268, 142, 463, 221, 882, 576, 604, 739, 288, 569, 256, 936, 275, 401, 497, 82, 935, 983, 583, 523, 697, 478, 147, 795, 380, 973, 958, 115, 773, 870, 259, 655, 446, 863, 735, 784, 3, 671, 433, 630, 425, 930, 64, 266, 235, 187, 284, 665, 874, 80, 45, 848, 38, 811, 267, 575};
        System.out.println(InversePairs(a));
    }

    static public int InversePairs(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int[] result = new int[array.length];
        int a = 0;
        //Merge1(array, result, 0, array.length - 1) % 1000000007;
        MergeSort(array, result, 0, array.length - 1);
        System.out.println(Arrays.toString(result));
        return a;
    }

    public static int Merge1(int[] arr, int[] result, int start, int end) {
        if (start == end)                    //递归结束条件
        {
            result[start] = arr[start];
            return 0;
        }
        //递归，分解数组到只剩一个值的情况
        int mid = (end + start) >> 1;
        int left = Merge1(arr, result, start, mid) % 1000000007;
        int right = Merge1(arr, result, mid + 1, end) % 1000000007;
        /*
        左结束，右结束
        结果数组的下标index;
        逆序数 count
         */
        int leftEnd = mid;
        int rightEnd = end;
        int index = end;
        int count = 0;

        while (leftEnd >= start && rightEnd > mid) {
            if (arr[leftEnd] > arr[rightEnd]) {
                result[index--] = arr[leftEnd--];
                //核心代码其实就这一句话，因为分解成的小数组在归并的时候，也是升序的，
                //大于某一个值，就会大于它前面的所有值
                count += rightEnd - mid;
                if (count >= 1000000007)//数值过大求余
                {
                    count %= 1000000007;
                }
            } else
                result[index--] = arr[rightEnd--];
        }
        for (; leftEnd >= start; leftEnd--)                //复制剩余的左边
        {
            result[index--] = arr[leftEnd];
        }
        for (; rightEnd > mid; rightEnd--)                 //复制右面的剩余
        {
            result[index--] = arr[rightEnd];
        }
        for (int i = start; i <= end; i++)                  //改变原数组
        {
            arr[i] = result[i];
        }
        return (count + left + right) % 1000000007;
    }

    public static void Merge2(int[] arr, int[] result, int start, int end) {
        /*
        代码整理了一下
         */
        if (start >= end)         //递归的结束条件
            return;
        int mid = (start+end)>> 1;
        int start1 = start, end1 = mid;
        int start2 = mid + 1, end2 = end;

        Merge1(arr, result, start1, end1);
        Merge1(arr, result, start2, end2);
        int k = start;
        while (start1 <= end1 && start2 <= end2) {
            result[k++] = arr[start1] < arr[start2] ? arr[start1++] : arr[start2++];
        }
        while (start1 <= end1)
            result[k++] = arr[start1++];
        while (start2 <= end2)
            result[k++] = arr[start2++];
        for (k = start; k <= end; k++)
            arr[k] = result[k];


    }

    public static void MergeSort(int[] arr, int[] result, int left, int right) {
        /*
        附加的一个递归的函数参考
         */
        if (left >= right) {
            result[left] = arr[left];
            return;
        }
        int mid = (left + right) / 2;
        MergeSort(arr, result, left, mid);
        MergeSort(arr, result, mid + 1, right);

        int leftStart = left;
        int rightStart = mid + 1;
        int k = 0;

        while (leftStart <= mid && rightStart <= right) {
            if (arr[leftStart] <= arr[rightStart]) {
                result[k++] = arr[leftStart++];
            } else {
                result[k++] = arr[rightStart++];
            }
        }
        while (leftStart <= mid) {
            result[k++] = arr[leftStart++];
        }
        while (rightStart <= right) {
            result[k++] = arr[rightStart++];
        }
        for (int x = 0; x < k; x++) {
            arr[leftStart + x] = result[x];
        }

    }

}
