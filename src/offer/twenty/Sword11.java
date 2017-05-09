package offer.twenty;

/**
 * Created by asus on 2017/3/21.
 */
public class Sword11 {
    public static void main(String[] arg) {
        System.out.println(Power1(2, 8));
    }

    static public double Power1(double base, int exponent) {
        /*
        其实这道题最重要的就是条件，一般都只考虑次方为整数，不出错才怪
         */
        int exponent1 = exponent;
        if (exponent == 0)
            return 1;
        if (exponent == 1)
            return base;
        /*
        递归相当于什么呢？就是在找次方从低位算的第一个1，递归几次，说明这个1代表2的几次方；
        比如8：01000，找到此时的1需要递归三次，递归一次相当于 a^n=a^n/2*a^n/2一次，三次就
        做三遍，如果次方为奇数，就再做一遍；
         */
        double result = Power1(base, exponent >> 1);
        /*
        这里其实相当于次方还有一个1，就翻了一倍
         */
        result *= result;
        if ((exponent & 1) == 1)
            result *= base;
        return exponent1 > 0 ? result : 1 / result;

    }

    static public double Power2(double base, int exponent) {
        /*
        神奇的抛出错误+普通的连续相乘
         */
        try {
            if (base == 0.0 && exponent < 0) {
                throw new ZeroException("");
            } else if (base == 0.0 && exponent >= 0) {
                throw new ZeroException("");
            }
        } catch (ZeroException e) {
            return 0.000000;
        }

        if (exponent == 0)
            return 1.0;

        double result = 1.0;
        int exponent1;

        if (exponent < 0)
            exponent1 = 0 - exponent;
        else
            exponent1 = exponent;
        for (int i = 0; i < exponent1; i++) {
            result = base * result;
        }
        if (exponent < 0)
            return 1 / result;
        return result;
    }
}

class ZeroException extends Exception {

    public ZeroException(String s) {
        System.err.println(s);
    }

}
