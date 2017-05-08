package offer.ten;

/**
 * Created by asus on 2017/3/20.
 */
public class Sword10 {
    public static void main(String[] arg) {
        //NumberOf1(-2147483648);
        System.out.println(Integer.toBinaryString(-1000000));
    }

    static public int NumberOf1(int n) {
        /*
        右移n，原数字改变了
         */
        int count = 0;
        while (n != 0) {
            if ((n & 1) == 1) {
                count++;
            }
            n = n >> 1;
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
        完全不知所云的神奇算法
         */
        int count = 0;
        while (n != 0) {
            count++;
            n = (n - 1) & n;
        }
        return count;
    }
}
