package offer.fifty;

/**
 * Created by asus on 2017/4/8.
 */
public class Seven {
    public  static void  main(String []arg)
    {
        System.out.println(Add(5, 0));
    }
    static public int Add(int num1,int num2) {
        int sum;
        int carry;
        do {
            sum =num1 ^num2 ;  //异或，不算进位的结果
            carry = (num1 & num2) <<1; //两个都是1就会进位，然后右移一位；
            num1 = sum;
            num2 = carry;               //进位如果不是零就可以跳出了
        }while (num2!=0);
        return  num1;
    }
    static public int Add1(int num1,int num2)
    {
        int sum;
        int carry;
        while (num2!= 0)
        {
            sum =num1 ^num2 ;  //异或，不算进位的结果
            carry = (num1 & num2) <<1; //两个都是1就会进位，然后右移一位；
            num1 = sum;
            num2 = carry;               //进位如果不是零就可以跳出了
        }
        return num1;
    }
}
