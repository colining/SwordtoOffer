package offer.fifty;

/**
 * Created by asus on 2017/4/8.
 */
public class Six {
    public static  void  main(String []arg)
    {
        System.out.println(Sum_Solution2(100));
    }

    static public int Sum_Solution1(int n) {
        try {
            int i=1%n;
            return n+Sum_Solution(n-1);
        }catch (Exception e)
        {
            return 0;
        }

    }
    static public int Sum_Solution(int n){
        int i = n;
        boolean flag = (n>0) && (n+=Sum_Solution(n-1))>0;
        return n;
    }
    static public int Sum_Solution2(int n)
    {
        return (int)(Math.pow(n,2)+n)>>1;
    }
}
