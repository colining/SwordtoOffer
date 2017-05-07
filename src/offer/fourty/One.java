package offer.fourty;

/**
 * Created by asus on 2017/3/30.
 */
public class One {
    public  static  void  main(String [] arg)
    {
        int [] array = {-2,-8,-1,-5,-9};
        System.out.println(FindGreatestSumOfSubArray1(array));
    }
   static public int FindGreatestSumOfSubArray(int[] array) {
       if (array==null&&array.length==0)
           return 0;
        int a=0;
        int max=Integer.MIN_VALUE;
        for ( int i = 0 ; i <array.length;i++)
        {
            if (a<=0)
                a=array[i];
            else
            a+=array[i];

            if ( a>max)
                max = a;
        }
        return  max;
    }

    static  public  int FindGreatestSumOfSubArray1(int [] array)
    {
        if (array.length==0)
            return 0;
        int sum = array[0],tempsum = array[0];
        for (int i =1;i<array.length;i++)
        {
            tempsum = (tempsum<0)?array[i]:array[i]+tempsum;
            sum = (tempsum>sum)? tempsum:sum;
        }
        return sum;
    }
}
