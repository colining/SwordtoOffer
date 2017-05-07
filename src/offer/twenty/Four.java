package offer.twenty;

import java.util.Arrays;

/**
 * Created by asus on 2017/3/22.
 */
public class Four {
    public  static  void  main(String [] arg)
    {
        int [] a = new int[]{2,1,3,4,17,6,7,8,9};
        reOrderArray4(a);
    }
   static public void reOrderArray(int [] array1) {             //头尾指针
       int array[] =array1;
        int k=0;
        int i = 0;
        int index=array.length-1;
        while (i<=index)
        {
            while ((array[index]&1)==0) {
                index--;
                if (index<=i)
                    break;
            }

            if ((array[i]&1)==0)
            {
                k=array[i];
                array[i]=array[index];
                array[index]=k;
                index--;
            }
            i++;
//            while (i<index&&(array[i]&1)==1)
//                i++;
//                k=array[i];
//                array[i]=array[index];
//                array[index]=k;
//                index--;

        }
       System.out.println(Arrays.toString(array));

   }

   static  public  void  reOrderArray1(int [] array)    //相邻交换
   {
       int k=0;
        for (int i = 0 ; i <array.length-1;i++)
            for (int j = 0 ;j<array.length-1;j++)
            {
                if ((array[j]&1)==0&&(array[j+1]&1)==1) //如果相邻元素一奇一偶就调换位置
                {
                    k=array[j];
                    array[j]=array[j+1];
                    array[j+1]=k;
                }
            }

   }

   static  public  void  reOrderArray2(int [] array)    //开辟数组
   {
       int test[] = new int[array.length];
       int j = 0;
       for (int i = 0 ; i < array.length; i ++)         //先倒腾奇数
           if ((array[i]&1)==1)
               test[j++]=array[i];
       for (int i = 0 ; i < array.length; i ++)         //在倒腾偶数
           if ((array[i]&1)==0)
               test[j++]=array[i];
        System.arraycopy(test, 0, array, 0, array.length);
       //System.out.println(Arrays.toString(array));

   }

    public static void reOrderArray3(int[] a) {
        if(a==null||a.length==0)
            return;
        int i = 0,j;
        while(i<a.length){
            while(i<a.length&&!isEven(a[i]))
                i++;
            j = i+1;
            while(j<a.length&&isEven(a[j]))
                j++;
            if(j<a.length){
                int tmp = a[j];
                for (int j2 = j-1; j2 >=i; j2--) {
                    a[j2+1] = a[j2];
                }
                a[i++] = tmp;
            }else{// 查找失敗
                break;
            }
        }
        System.out.println(Arrays.toString(a));
    }
    static boolean isEven(int n){
        if(n%2==0)
            return true;
        return false;
    }

    public  static  void  reOrderArray4(int [] array)
    {
        for ( int i =0 ; i <array.length;i++)
        {   int j ;
            if ((array[i]&1)==1)
            {
                j=i-1;
                int temp=array[i];
                while (j>=0&&(array[j]&1)==0)               //插排中，直到前面没有偶数就停下来
                {                                           //其实也就等于把那些元素全部向后移动了
                    array[j+1]=array[j];
                    j--;
                }
                array[j+1]=temp;
            }
        }
        System.out.println(Arrays.toString(array));
    }

}
