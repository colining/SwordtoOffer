package offer.fifty;

/**
 * Created by asus on 2017/4/5.
 */
public class Four {
    public  static void  main(String []arg)
    {
            int [] a = {0,1,6,4,5};
        System.out.println(isContinuous(a));
    }
    static public boolean isContinuous(int [] numbers) {
        if (numbers==null||numbers.length<5)            //输入检测
            return  false;
        int [] back = numbers.clone();                  //无聊克隆一下数组
        int start=0;
        int numberofzero=0;                             //大小王个数
        numbers= quick_sort1(numbers,start,numbers.length-1); //排序
        while (start<numbers.length)                    //获取0的个数
        {
            if (numbers[start]==0)
                numberofzero++;
            start++;
        }
        start=numberofzero;
        int end = numberofzero+1;
        int needzero = 0;                               //所需要的0
        while (end<numbers.length)
        {
            if (numbers[start]==numbers[end])
                return false;
            else
                needzero += numbers[end]-numbers[start]-1;
            end++;
            start++;
        }
        return (needzero>numberofzero)?false:true;
    }
    public  static  int AdujustArray(int array[], int left , int right)
    {
        int i =left;
        int j= right;
        int x = array[left];
        while (i<j)
        {
            while (array[j]>=x&&i<j)
                j--;
            if (i<j) {
                array[i] = array[j];
                i++;
            }

            while (array[i]<x&&i<j)
                i++;
            if (i<j) {
                array[j] = array[i];
                j--;
            }
        }
        array[i]=x;
        return i;
    }
    public  static  int [] quick_sort1(int s[] , int l,int r)
    {
        if (l<r)
        {
            int i = AdujustArray(s,l,r);
            quick_sort1(s,l,i-1);
            quick_sort1(s,i+1,r);
        }
        return s;
    }
}
