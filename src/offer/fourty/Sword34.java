package offer.fourty;

/**
 * Created by colin on 2017/3/31.
 */
public class Sword34 {
    /* 丑数
    把只包含因子2、3和5的数称作丑数（Ugly Number）。
    例如6、8都是丑数，但14不是，因为它包含因子7。
    习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
     */
    public static void main(String[] arg) {
        int a = 10;
        for (int i = 0; i < a; i++) {
            System.out.print(GetUgly(i) + ",");
        }
    }

    static public int GetUgly(int index) {
        /*
        丑数应该是从小到大的，当前这个一定是上一个组三种丑数，再乘以
        2，3,5所得到的；
         */
        if (index <= 0)
            return 0;
        int ugly[] = new int[index];
        ugly[0] = 1;
        int pow2 = 0, pow3 = 0, pow5 = 0;
        for (int i = 1; i < index; i++) {
            ugly[i] = Math.min(5 * ugly[pow5], Math.min(2 * ugly[pow2], 3 * ugly[pow3]));
            if (ugly[i] == 2 * ugly[pow2])
                pow2++;
            if (ugly[i] == 3 * ugly[pow3])
                pow3++;
            if (ugly[i] == 5 * ugly[pow5])
                pow5++;
        }
        return ugly[index - 1];
    }


}
