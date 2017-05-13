package offer.thirty;

import java.util.ArrayList;
import java.util.TreeSet;

/**
 * Created by asus on 2017/3/29.
 */
public class Sword30 {
    public static void main(String[] arg) {
        int[] n = null;
        int[] n1 = {4, 5, 1, 6, 2, 7, 3, 8};
        int[] n2 = {8, 5, 3, 2, 1, 5};
        ArrayList arrayList = new ArrayList();
        arrayList = GetLeastNumbers_Solution2(n, 4);
        arrayList = GetLeastNumbers_Solution2(n1, 10);
        arrayList = GetLeastNumbers_Solution3(n2, 4);
    }
    //解法一
    public static ArrayList<Integer> GetLeastNumbers_Solution1(int[] input, int k) {
        //输入检测
        ArrayList arrayList = new ArrayList();
        if (input == null || k <= 0 || k > input.length || input.length <= 0)
            return arrayList;
        //寻找位置为k的哨兵，调整数组
        int left = 0;
        int right = input.length - 1;
        int index = AdjustArray(input, left, right);
        while (index != k - 1) {
            if (index < k - 1) {
                left = index + 1;
                index = AdjustArray(input, left, right);
            } else {
                right = index - 1;
                index = AdjustArray(input, left, right);
            }

        }
        for (int i = 0; i < k; i++) {
            arrayList.add(input[i]);
        }
        return arrayList;
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

    //解法二
    public static ArrayList<Integer> GetLeastNumbers_Solution2(int[] input, int k) {
        //利用了treeSet数据结构
        ArrayList arrayList = new ArrayList();
        if (input == null || k <= 0 || k > input.length || input.length <= 0)
            return arrayList;
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int i = 0; i < input.length; i++) {
            treeSet.add(input[i]);
        }
        for (int i = 0; i < k; i++) {
            arrayList.add(treeSet.pollFirst());
        }
        return arrayList;
    }

    public static ArrayList<Integer> GetLeastNumbers_Solution3(int[] input, int k) {
        ArrayList arrayList = new ArrayList();
        if (input == null || k <= 0 || k > input.length || input.length <= 0)
            return arrayList;
        int[] array = BuildMaXHeap(input);
        for (int i = array.length - 1; i > array.length - 1 - k; i--) {
            //0结点就是父节点，每次调换最后一个节点和父节点，进行堆得排序
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;
            //添加当前的父节点，也就是最小的结点
            arrayList.add(temp);
            AdjustMaxHeap(array, 0, i);
        }
        return arrayList;
    }

    public static int[] BuildMaXHeap(int[] array) {
        /*
        小根堆如果从一开始计数，ki就是k2i,k(2i+1)的父节点；
        但是数组是从零计数的，个数就是数组长度，父节点下标就是/2再减去一；
         */
        for (int i = (array.length - 2) / 2; i >= 0; i--) {
            AdjustMaxHeap(array, i, array.length);
        }
        return array;
    }

    public static void AdjustMaxHeap(int[] array, int father, int length) {
        int temp = array[father];                            //当前要调整的父节点
        /*
         j是他的子节点，如果继续循环，说明当前节点已经向下移动了了一层
         每次都是父节点与他的子节点进行比较
         */
        for (int child = 2 * father + 1; child < length - 1; child = 2 * father + 1) {
            if (child < length && array[child] > array[child + 1])    //如果右节点比左节点小，就变化下标
            {                                                        //选出子节点中小的，和父节点比较一下，看看是不是需要调换
                child++;
            }
            if (temp <= array[child])                                //父节点小于当前子节点的最小值，说明这个父节点为首的小根堆没有问题
                break;
            else {
                array[father] = array[child];                        //父节点和子节点调换位置
                father = child;                                      //记录父节点更换到的位置，继续下一次的循环
            }
        }
        array[father] = temp;                                        //父节点可能会有多次移动，所以最后一次移动结束。再赋值

    }
}
