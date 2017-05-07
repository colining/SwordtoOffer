package offer.ten;

/**
 * Created by asus on 2017/3/20.
 */
public class Ten  {
    public  static  void  main(String [] arg)
    {
            //NumberOf1(-2147483648);
        System.out.println(Integer.toBinaryString(-1000000));
    }
   static public int NumberOf1(int n) {
            int count = 0;
        while (n!=0)
        {
            if ((n&1)==1)
            {
                count++;

            }
            n = n>>1;
        }
        return  count;

    }
    static  public  int NumberOf(int n)
    {
        int count = 0 ;

        while ( n!=0)
        {
            count++;
            n=(n-1)&n;
        }
        return count;
    }
    static  public  int NumberOf2(int n)
    {
        int count = 0;
        int flag = 1;
        while (n!=0)
        {
            if ((n&flag)==1)
                count++;
            flag=flag<<1;
        }
        return  count;
    }
}
