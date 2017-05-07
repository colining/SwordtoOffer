package offer.thirty;

/**
 * Created by asus on 2017/3/27.
 */
public class Nine {
    public  static  void  main(String [] arg)
    {
        int a[] = {1,2,3,2,2,2,5,4,2};
        int b[]=new int[1];
        System.out.println(MoreThanHalfNum_Solution1(a));
    }
  static   public int MoreThanHalfNum_Solution(int [] array) {
        int a=0;
        if (array==null||array.length<=0)
            return a;
        else if (array.length==1)
            return 1;
        int start = 0;
        int end = array.length-1;
        int middle = array.length>>1;
        int index = AdujustArray(array,start,end);
        while (index!=middle)
        {
            if (index>middle) {
                end = index-1;
                index = AdujustArray(array, start, end);
            }
            else {
                start=index+1;
                index = AdujustArray(array, start, end);
            }
        }
        int number = array[middle];
        int times = 0 ;
        for (int i = 0; i < array.length; i++) {
            if (array[i]==number)
                times++;
        }
        if (times*2<=array.length)
        return a;
        else
            return number;
    }
    public  static  int AdujustArray(int array[], int left , int right)
    {
        int i =left;
        int j= right;
        int x = array[left];
        while (i<j)
        {
            while (array[j]>=x&&i<j)
                j--;
            if (i<j) {
                array[i] = array[j];
                i++;
            }

            while (array[i]<x&&i<j)
                i++;
            if (i<j) {
                array[j] = array[i];
                j--;
            }
        }
        array[i]=x;
        return i;
    }

    public static  int MoreThanHalfNum_Solution1(int array[])
    {
        int a =0;
        if (array==null||array.length<=0)
            return a;
        else if (array.length==1)
            return array[0];
        int times = 1;
        int result = array[0];
        for (int i = 1 ;i<array.length;++i)
        {
            if (times==0)
            {
                result=array[i];
                times=1;
            }
            else if (array[i]==result)
                {
                    times++;
                }
            else
                times--;
        }
        int number = result;
        int time = 0 ;
        for (int i = 0; i < array.length; i++) {
            if (array[i]==number)
                time++;
        }
        if (time*2<=array.length)
            return a;
        else
            return number;
    }
}
