package offer.fourty;

/**
 * Created by colin on 2017/4/2.
 */
public class Sword40 {
    /* 数组中只出现过一次的数字
     一个整型数组里除了两个数字之外，
     其他的数字都出现了两次。
     请写程序找出这两个只出现一次的数字。
     */
    public static void main(String[] arg) {

    }

    public void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {
        /*
        基本思路是异或运算，相同的值异或为0，不同异或为1；

         */
        if (array == null || array.length < 2)            //用例检查
            return;
        int allxor = 0;
        //对数组进行异或运算，相同的抵消，最后的结果就是两个只出现过一次的数的异或
        for (int i = 0; i < array.length; i++) {
            allxor ^= array[i];
        }
        //只出现过一次的两个数异或一定不是0，所以二进制中一定含有1；
        //也就是说，一个值这个位置为0，另一个这个位置为1；
        //这样就可以分组了
        int flag = 1;
        while ((allxor & flag) == 0)                      //找的这么一个特征值
            flag <<= 1;                                   //移动1的位置

        //分组进行异或运算，每组都只有一个只出现过一次的值
        //所以最后结果就是他们
        for (int i = 0; i < array.length; i++) {          //通过特征值分组
            if ((array[i] & flag) == 0)
                num1[0] ^= array[i];
            else
                num2[0] ^= array[i];
        }
    }

}
