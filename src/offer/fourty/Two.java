package offer.fourty;

/**
 * Created by asus on 2017/3/30.
 */
public class Two {
    public  static  void  main(String []arg)
    {
        System.out.println(NumberOf1Between1AndN_Solution1(10000));
    }
  static   public int NumberOf1Between1AndN_Solution(int n) {
          int a=0;
      for (int i = 0; i <=n; i++) {
          int number = 0 ;
          int j = i;
          while (j>0)
          {
              if ( (j % 10) ==1)
                  number++;
                  j=j/10;

          }
          a+=number;
      }
          return  a;
    }
    static   public int NumberOf1Between1AndN_Solution1(int n) {
        int temp = n ;                  //temp 复制一个n的备份
        int timeof1=0;
        int current;
        int power = 0;
        while (n>0)
        {
           current = n%10;
            n/=10;
            if (current>1)
                timeof1+= (n+1)*Math.pow(10,power);
            else  if (current==1)
                timeof1+= (n)*Math.pow(10,power) +temp%Math.pow(10,power)+1;
            else
                timeof1+= n*Math.pow(10,power);

            power++;
        }
        return  timeof1;
    }
    static  public  int NumberOf1Between1AndN_Solution2(int n)
    {
        int ones = 0;
        for (long m = 1; m <= n; m *= 10)
            ones += (n/m + 8) / 10 * m + (n/m % 10 == 1 ? n%m + 1 : 0);
        return ones;
    }

}
