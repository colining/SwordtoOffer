package offer.fifty;

/**
 * Created by colin on 2017/4/8.
 */
public class Sword47 {
    /*
    不用加减乘除做加法运算
     */
    public static void main(String[] arg) {
        System.out.println(Add(5, 0));
    }

    static public int Add(int num1, int num2) {
        int sum;
        int carry;
        do {
            sum = num1 ^ num2;          //异或，得到不算进位的结果
            carry = (num1 & num2) << 1; //两个都是1就会进位，进位的这个一右移一位就可以通过异或加上去；
            num1 = sum;
            num2 = carry;
        } while (num2 != 0);            //如果没有进位就可以跳出了
        return num1;
    }

    static public int Add1(int num1, int num2) {
        int sum;
        int carry;
        while (num2 != 0) {
            sum = num1 ^ num2;          //异或，不算进位的结果
            carry = (num1 & num2) << 1; //两个都是1就会进位，然后右移一位；
            num1 = sum;
            num2 = carry;               //进位如果不是零就可以跳出了
        }
        return num1;
    }
}
