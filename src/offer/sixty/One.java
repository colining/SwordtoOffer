package offer.sixty;

import java.util.HashSet;

/**
 * Created by asus on 2017/4/9.
 */
public class One {
    public static  void  main(String []arg)
    {

    }
    public boolean duplicate(int numbers[],int length,int [] duplication) {
        if (numbers==null||numbers.length==0)
        {
            return false;

        }
        HashSet<Integer> hashSet = new HashSet();
        boolean flag = false;
        for (int i = 0; i < numbers.length; i++) {
            if (hashSet.contains(numbers[i])) {
                duplication[0] = numbers[i];
                flag = true;
            }
            else
            hashSet.add(numbers[i]);
        }
        return flag;
    }

    public boolean duplicate1(int numbers[],int length,int [] duplication)
    {
        if (numbers==null||numbers.length==0)
        {
            return false;

        }
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i]<0||numbers[i]>numbers.length-1)
                return false;
        }
        for (int i = 0; i < numbers.length; i++) {
            while (numbers[i]!= i)
            {
                if (numbers[i] == numbers[numbers[i]])
                {
                    duplication[0] = numbers [i];
                    return  true;
                }
                int temp = numbers[i];
                numbers[i] = numbers[temp];
                numbers[temp] = temp ;
            }
        }
        return  false;
    }
}
