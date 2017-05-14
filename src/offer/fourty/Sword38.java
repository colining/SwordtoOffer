package offer.fourty;

/**
 * Created by colin on 2017/4/2.
 */
public class Sword38 {
    /* 数字在排序数组中的出现次数
    统计一个数字在排序数组中出现的次数。
     */
    public static void main(String[] arg) {
        int a[] = {1, 3, 3, 3, 3, 4, 5};
        System.out.println(GetNumberOfK(a, 2));
    }

    static public int GetNumberOfK(int[] array, int k) {
        if (array == null || array.length == 0)
            return 0;
        /*
        分治的想法，找前面，找后面，合起来就就好了
        主要想法是二分查找，优先定位到要查找的数，然后再一位一位寻找
        起始或者终点位置
         */
        int first = GetFirst(array, k, 0, array.length - 1);
        int last = GetLast(array, k, 0, array.length - 1);
        return (first > -1 && first > -1) ? last - first + 1 : 0;
    }

    static public int GetFirst(int[] arr, int k, int start, int end) {
        //递归结束条件，到达这一步其实就说明找不到了
        if (start > end)
            return -1;
        int mid = (start + end) >> 1;
        //寻找到这个数的边界位置，一种是当前位置和它前面不一样，另一种是当前就在第一位
        if (arr[mid] == k) {
            if ((mid == 0) || (mid > 0 && arr[mid - 1] != k)) {
                return mid;
            } else
                end = mid - 1;
        } else if (arr[mid] < k) {
            start = mid + 1;
        } else if (arr[mid] > k)
            end = mid - 1;

        return GetFirst(arr, k, start, end);
    }

    static public int GetLast(int[] arr, int k, int start, int end) {
        /*
        想法和寻找开头是一样的；
         */
        if (start > end)
            return -1;
        int mid = (start + end) >> 1;
        if (arr[mid] == k) {
            if (mid == arr.length - 1 || (mid < arr.length - 1 && arr[mid + 1] != k))
                return mid;
            else
                start = mid + 1;
        } else if (arr[mid] > k)
            end = mid - 1;
        else if (arr[mid] < k)
            start = mid + 1;
        return GetLast(arr, k, start, end);
    }
}
