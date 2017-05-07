package offer.fourty;

/**
 * Created by asus on 2017/4/2.
 */
public class Ten {
    public  static void  main(String []arg)
    {

    }
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        if (array==null||array.length<2)            //用例检查
            return;
        int allxor=0;                               //用于全部异或
        for (int i = 0; i < array.length; i++) {
            allxor^= array[i];
        }
        int flag = 1;
        while ((allxor & flag)==0)                  //找的这么一个特征值
            flag <<= 1;                             //移动1的位置

        for (int i = 0; i < array.length; i++) {    //通过特征值分组
            if ((array[i]&flag)==0)
                num1[0] ^= array[i];
            else
                num2[0] ^= array[i];
        }
    }

}
