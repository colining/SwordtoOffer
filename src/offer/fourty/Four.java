package offer.fourty;

/**
 * Created by asus on 2017/3/31.
 */
public class Four {
    public static  void  main(String []arg)
    {
        int a=10;
        for (int i = 0; i < a; i++) {
            System.out.print(GetUgly1(i)+",");
        }

    }
    public  int GetUgly(int index)
    {
        if (index<=0)
            return 0;
        int number=0;
        int UglyFound = 0;
        while (UglyFound<index)
        {
            ++number;
            if (isUgly(number))
            {
                UglyFound++;
            }
        }
        return number;
    }
   static public int GetUgly1(int index)
    {
        if (index<=0)
            return 0;
        int a[]=new int[index];
        a[0]=1;
        int pow2=0,pow3=0,pow5=0;
        for (int i = 1; i < index; i++) {
            a[i]=Math.min(5*a[pow5],Math.min(2*a[pow2],3*a[pow3]));
            if (a[i]==2*a[pow2])
                pow2++;
            if (a[i]==3*a[pow3])
                pow3++;
            if (a[i]==5*a[pow5])
                pow5++;

        }
        return a[index-1];
    }


    public static boolean isUgly(int number)
    {
        while (number%2==0)
            number/=2;
        while (number%3==0)
            number/=3;
        while (number%5==0)
            number/=5;
        return (number==1)?true:false;

    }
}
