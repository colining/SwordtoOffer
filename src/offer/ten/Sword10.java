package offer.ten;

/**
 * Created by colin on 2017/3/20.
 */
public class Sword10 {
    /* 二进制中一的个数
    输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
     */
    public static void main(String[] arg) {
        //NumberOf1(-2147483648);
        System.out.println(Integer.toBinaryString(-1000000));
        NumberOf1(-5);
    }

    static public int NumberOf1(int n) {
        /*
        右移n，原数字改变了
        &运算， 1 & 1 = 1,1 & 0= 0, 0 & 0 =0;
        如果是负数，第一位为1，需要继续右移，程序出错
         */
        int count = 0;
        while (n != 0) {
            System.out.println(Integer.toBinaryString(n));
            if ((n & 1) == 1) {
                count++;
            }
            n = n >> 1;
            System.out.println("");
        }
        return count;
    }

    static public int NumberOf2(int n) {
        /*
        左移用作比较的flag；从最低位1，将其移动到10,100，这样进行比较
         */
        int count = 0;
        int flag = 1;
        while (n != 0) {
            if ((n & flag) == 1)
                count++;
            flag = flag << 1;
        }
        return count;
    }

    static public int NumberOf3(int n) {
        /*
        完全不知所云的神奇算法,其实就是 n-1 会让从最低位开始算的第一个1转换为0，其它的等于去反，
        这样在和n取与，一定都是0；这样能算几次，就证明有多少个1；
         */
        int count = 0;
        while (n != 0) {
            count++;
            n = (n - 1) & n;
        }
        return count;
    }
}
