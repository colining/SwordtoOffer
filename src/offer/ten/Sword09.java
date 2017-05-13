package offer.ten;

/**
 * Created by colin on 2017/3/20.
 */
public class Sword09 {
    /* 斐波那契数列
    大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项。
     */
    public static void main(String[] arg) {
        System.out.println(Fibonacci1(3));
    }

    static public int Fibonacci(int n) {
       /*
       典型递归，效率极低
        */
        if (n <= 0)
            return 0;
        if (n == 1)
            return 1;
        else
            return Fibonacci(n - 1) + Fibonacci(n - 2);
    }

    static public int Fibonacci1(int n) {
        /*
        其实就是从正面求解斐波那契数列，从f(0)往后加
         */
        if (n < 2)
            return n;
        int x = 0;
        int y = 1;
        int result = 0;
        for (int i = n; i >= 2; i--) {
            result = x + y;
            x = y;
            y = result;
        }
        return result;
    }

    /*
    一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
    青蛙跳 斐波那契变形
     */
    public int JumpFloor(int target) {

        if (target <= 2)
            return target;

        int x = 1;
        int y = 1;
        int test = 0;
        for (int i = target; i >= 2; i--) {
            test = x + y;
            x = y;
            y = test;
        }
        return test;
    }

    /*
    变态青蛙跳
     一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。
    求该青蛙跳上一个n级的台阶总共有多少种跳法？
     */
    public int JumpFloorII(int target) {
        if (target <= 0)
            return 0;
        else if (target == 1)
            return 1;
        else
            return JumpFloorII(target - 1);
    }

    public int JumpFloorII1(int target) {
        return 1 << --target;
    }

    public int JumpFloorII2(int target) {
        if (target <= 0)
            return 0;
        int sum = 1;
        while (--target != 0) {
            sum = 2 * sum;
        }
        return sum;
    }
}
