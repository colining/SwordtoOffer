package offer.ten;

/**
 * Created by asus on 2017/3/20.
 */
public class Sword08 {
    public static void main(String[] arg) {
        int a[] = {6, 1, 2, 3, 4, 5};
        System.out.println(minNumberInRotateArray(a));
    }

    static public int minNumberInRotateArray(int[] array) {
        if (array.length == 0)
            return 0;
        return solution2(array);
        //return  solution(array);
    }

    static int solution(int[] array) {
        /*
        判断是否完全旋转 比如 1,2,3,4，旋转为1,2,3,4；第一个一定小于第二个；
        但是如果是 1,1,1,的话就无法判断，所以再寻找一圈最小值后，不返回就返回第一个数
         */
        if (array[0] < array[array.length - 1])
            return array[0];
        /*
        寻找第一个比它前一个小的数
         */
        for (int i = 0; i < array.length; i++) {
            if (array[i] > array[i + 1]) {
                return array[i + 1];
            }
        }
        //没找着，就直接返回
        return array[0];
    }

    static int solution2(int[] array) {
        if (array.length == 0)
            return 0;

        int start = 0;
        int end = array.length - 1;
        int mid = start;

        while (array[start] >= array[end]) {
            if (end - start == 1) {
                mid = end;
                break;
            }
            mid = (start + end) / 2;
            /*
            类似 1,3,3 旋转为 3,1,3，头尾无法判定，就直接遍历好嘞
             */
            if (array[start] == array[mid] && array[mid] == array[end]) {
                return MinOrder(array, start, end);
            }
            /*
            正常的二分查找
             */
            if (array[mid] >= array[start])
                start = mid;
            else if (array[mid] <= array[end])
                end = mid;
        }
        return array[mid];

    }

    static int MinOrder(int array[], int start, int end) {
        int result = array[start];
        for (int i = start + 1; i <= end; ++i) {
            if (result > array[i])
                result = array[i];
        }
        return result;
    }

}
