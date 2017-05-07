package offer.twenty;

/**
 * Created by asus on 2017/3/21.
 */
public class One {
    public  static  void  main (String [] arg)
    {
        System.out.println(Power1(2, -2));

    }
    static public double Power(double base, int exponent) {
        try {
            if (base==0.0&&exponent<0) {
                throw new  ZeroException("");
            }
            else if (base==0.0&&exponent>=0)
            {
                throw  new ZeroException("");
            }
        }catch (ZeroException e)
        {
                return 0.000000;
        }
        if (exponent==0)
            return  1.0;
        double a = 1.0;
        int ex1=0;
        if(exponent<0)
            ex1= 0-exponent;
        else
            ex1=exponent;
        for (int i = 0 ; i < ex1;i++)
        {
            a=base*a;
        }
        if (exponent<0)
            return 1/a;

        return  a;
    }

    static  public  double Power1(double base ,int exponent)
    {
        int n=exponent;
        exponent=Math.abs(exponent);
        if (exponent==0)
            return 0;
        if (exponent==1)
            return base;
        double result = Power1(base,exponent>>1);
        result*=result;
        if ((exponent&1)==1)
         result*=base;
        return n>0?result:1/result;

    }
}

class  ZeroException extends  Exception {

    public ZeroException(String s) {
        System.err.println(s);
    }
}
