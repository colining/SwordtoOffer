package offer.fifty;

/**
 * Created by colin on 2017/4/8.
 */
public class Sword46 {
    /*
    求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
     */
    public static void main(String[] arg) {
        System.out.println(Sum_Solution1(100));
    }

    static public int Sum_Solution1(int n) {
        //循环依靠递归来做，条件靠try catch来做
        try {
            //这句话，只用于抛出错误
            int i = 1 % n;
            return n + Sum_Solution1(n - 1);
        } catch (Exception e) {
            return 0;
        }

    }

    static public int Sum_Solution2(int n) {
        //循环依靠递归，条件依靠 && ；
        int i = n;
        boolean flag = (n > 0) && (n += Sum_Solution2(n - 1)) > 0;
        return n;
    }

    static public int Sum_Solution3(int n) {
        //公式
        return (int) (Math.pow(n, 2) + n) >> 1;
    }
}
