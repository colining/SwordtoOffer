package offer.fourty;

/**
 * Created by colin on 2017/3/30.
 */
public class Sword32 {
    /* 整数1出现的次数
    输入一个数字，输出从1到这个数字，1出现的次数
     */
    public static void main(String[] arg) {
        System.out.println(NumberOf1Between1AndN_Solution1(10000));
    }

    public static int NumberOf1Between1AndN_Solution1(int n) {
        /*
        蛮力法，对每一个数值都进行探测，
         */
        int num = 0;
        for (int i = 0; i <= n; i++) {
            int currentNum = 0;
            int j = i;
            while (j > 0) {
                if ((j % 10) == 1)
                    currentNum++;
                j = j / 10;

            }
            num += currentNum;
        }
        return num;
    }

    public static int NumberOf1Between1AndN_Solution2(int n) {
        /*
        根据数字特性来求 比如2515，对于十位1来说，它前面是25，所以从
        010~019，是10个，110~119，是10个，以此类推，到2419有25个，直到
        2509；如果原数字为2520，那么久包含2510~2519，就是n+1了，否则就分开计算
         */
        int temp = n;                  //temp 复制一个n的备份
        int num = 0;                   //0的个数
        int current;                   //当前位的数值
        int power = 0;                 //次方数
        while (n > 0) {
            current = n % 10;
            n /= 10;
            if (current > 1)
                num += (n + 1) * Math.pow(10, power);
            else if (current == 1)
                num += (n) * Math.pow(10, power) + temp % Math.pow(10, power) + 1;
            else
                num += n * Math.pow(10, power);
            power++;                    //位数削减了，次方升高，1出现的次数变多
        }
        return num;
    }

    public static int NumberOf1Between1AndN_Solution3(int n) {
        /*
        几乎没有可读性的神奇代码，看看就好
         */
        int ones = 0;
        for (long m = 1; m <= n; m *= 10)
            ones += (n / m + 8) / 10 * m + (n / m % 10 == 1 ? n % m + 1 : 0);
        return ones;
    }

}
