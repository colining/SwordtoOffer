package offer.fourty;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by colin on 2017/3/31.
 */
public class Sword33 {
    /* 把数组排成最小的数
    输入一个正整数数组，把数组里所有数字拼接起来排成一个数，
    打印能拼接出的所有数字中最小的一个。
    例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
     */
    public static void main(String[] arg) {
        int a[] = {3, 32, 321};
        System.out.println(PrintMinNumber(a));
    }

    static public String PrintMinNumber(int[] numbers) {
        /*
        在拼接的时候进行比较，通过字符串比较出谁更加的小；
        接住了String 现成的compareTo函数
         */
        int length;
        String sumString = "";
        ArrayList<Integer> list = new ArrayList<>();
        length = numbers.length;
        for (int i = 0; i < length; i++) {
            list.add(numbers[i]);
        }

        Collections.sort(list, new Comparator<Integer>() {                  //重写sort的函数
            @Override
            public int compare(Integer o1, Integer o2) {                    //重写sort实际上是重写了Comparator<>接口中的compare而已
                String s1 = o1 + "" + o2;
                String s2 = o2 + "" + o1;
                return s1.compareTo(s2);                                    //这里比较方便的借用了compareTo函数，其实可以自己写
            }
        });

        for (int i : list) {
            sumString += i;
        }
        return sumString;
    }
}
