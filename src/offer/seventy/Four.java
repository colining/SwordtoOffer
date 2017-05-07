package offer.seventy;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by asus on 2017/5/6.
 */
public class Four {
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
