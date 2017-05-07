package offer.fourty;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by asus on 2017/3/31.
 */
public class Three {
    public  static  void  main ( String [] arg)
    {
        int a [] = {3,32,321};
        System.out.println(PrintMinNumber(a));
    }
   static public String PrintMinNumber(int [] numbers) {
        int length ;
        String s = "";
        ArrayList<Integer> list = new ArrayList<>();
        length = numbers.length;

        for (int i = 0 ; i <length; i++)
        {
            list.add(numbers[i]);
        }

        Collections.sort(list, new Comparator<Integer>() {                  //重写sort的函数
            @Override
            public int compare(Integer o1, Integer o2) {                    //重写sort实际上是重写了Comparator<>接口中的compare而已
                String s1 = o1+""+o2;
                String s2 = o2+""+o1;
                return  s1.compareTo(s2);                                   //这里比较方便的借用了compareTo函数，其实可以自己写
            }
        });

        for (int j :list)
        {
            s+=j;
        }
        return  s;
    }
}
