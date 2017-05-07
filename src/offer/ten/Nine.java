package offer.ten;

/**
 * Created by asus on 2017/3/20.
 */
public class Nine {
    public  static  void  main(String [] arg)
    {
        System.out.println(Fibonacci1(3));
    }
   static public int Fibonacci(int n) {
        if ( n<= 0 )
            return  0 ;
       if (n == 1 )
           return  1;
       else
           return  Fibonacci(n-1)+Fibonacci(n-2);
    }
    static  public  int Fibonacci1 (int n)
    {
        if ( n<2)
        return  n;
        int x= 0;
        int y = 1;
        int test = 0;
        for ( int i=n;i>=2;i--)
        {
            test = x+y;
            x=y;
            y=test;
        }
        return  test;
    }
    public int JumpFloor(int target) {

        if (target<=2)
            return  target;

        int x = 1;
        int y = 1;
        int test = 0;
        for (int i = target;i>=2;i--)
        {
            test = x+y;
            x=y;
            y=test;
        }
    return  test;
    }
}
