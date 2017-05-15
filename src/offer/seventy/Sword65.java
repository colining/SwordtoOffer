package offer.seventy;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

/**
 * Created by colin on 2017/5/6.
 */
public class Sword65 {
    /* 滑动窗口的最大值
    给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
    例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一共存在6个滑动窗口，它们的最大值分别为{4,4,6,6,6,5}；
     针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个：
     {[2,3,4],2,6,2,5,1}，
     {2,[3,4,2],6,2,5,1}，
     {2,3,[4,2,6],2,5,1}，
     {2,3,4,[2,6,2],5,1}，
     {2,3,4,2,[6,2,5],1}，
     {2,3,4,2,6,[2,5,1]}。
     */
    public static void main(String[] args) {
        int[] a = {2, 3, 4, 2, 6, 2, 5, 1};
        int size = 3;
        maxInWindows(a, size);
    }

    static public ArrayList<Integer> maxInWindows(int[] num, int size) {

        ArrayList<Integer> arrayList = new ArrayList<>();
        Deque<Integer> deque = new ArrayDeque();            //储存数组的下标
        int i = 0;
        int currentPosition;                                //当前窗口最小的下标
        /*
        对于一个窗口来说
         */
        while (i < num.length) {
            currentPosition = i - size + 1;
            if (deque.isEmpty()) {
                deque.add(i);
            //队列里的第一个下标小于窗口最小下标，就移出
            } else if (currentPosition > deque.peekFirst()) {
                deque.pollFirst();
            }
            //新来的下标对应得数组元素值要比当前储存的大，就把它们全扔出去，只记录最大的
            while (!deque.isEmpty() && num[i] >= num[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.addLast(i);
            i++;
            if (currentPosition >= 0) {
                arrayList.add(num[deque.peekFirst()]);
            }
        }
        return arrayList;
    }
}
