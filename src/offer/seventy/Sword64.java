package offer.seventy;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by colin on 2017/5/6.
 */
public class Sword64 {
    /* 数据流中的中位数
    如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，
    那么中位数就是所有数值排序之后位于中间的数值。
    如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
     */
    public static void main(String[] args) {
        System.out.println((3 & 1));
    }

    int count;
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(12, new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2.compareTo(o1);
        }
    });

    public void Insert(Integer num) {
        /*
        核心思路，将字符直接分别在大顶堆和小顶堆中，堆顶便是中间部分的元素
         */
        count++;
        if ((count & 1) == 0) {                              //当前为偶数
            maxHeap.offer(num);
            minHeap.offer(maxHeap.poll());
        } else {
            minHeap.offer(num);
            maxHeap.offer(minHeap.poll());
        }
    }

    public Double GetMedian() {
        double result;
        return result = (count & 1) == 1 ? maxHeap.peek() : (minHeap.peek() + maxHeap.peek()) / 2.0;

    }

}
