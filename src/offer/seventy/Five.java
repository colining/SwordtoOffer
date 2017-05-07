package offer.seventy;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

/**
 * Created by asus on 2017/5/6.
 */
public class Five {
    public static void main(String[] args) {
        int [] a = {2,3,4,2,6,2,5,1};
        int size = 3;
        maxInWindows(a,size);
    }
    static public ArrayList<Integer> maxInWindows(int[] num, int size) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        Deque<Integer> deque = new ArrayDeque();
        int i = 0;
        int currentpostion = 0;
        while (i < num.length) {
            currentpostion = i - size + 1;
            if (deque.isEmpty()) {
                deque.add(i);
            } else if (currentpostion>deque.peekFirst())
            {
                deque.pollFirst();
            }
            while (!deque.isEmpty() && num[i] >= num[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.addLast(i);
                i++;
            if (currentpostion >=0)
            {
                arrayList.add(num[deque.peekFirst()]);
            }
        }
        return arrayList;
    }
}
