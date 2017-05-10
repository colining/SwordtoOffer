package offer.fifty;

import java.util.ArrayList;

/**
 * Created by asus on 2017/4/2.
 */
public class One {
    public  static  void  main(String []arg)
    {
//        int DoesTreeHaveTree[] = {1,2,4,7,11,15};
//        FindNumbersWithSum(DoesTreeHaveTree, 15);
//        System.out.println("aaa");
        FindContinuousSequence1(15);
        System.out.println(arrayLists);
        System.out.println("lll");
        int a= 2;
        int b = 4;
        System.out.println(b ^ a);
    }
  static   public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
                int head = 0 ;
                int end = array.length-1;
            ArrayList<Integer> arrayList = new ArrayList<>();
            if (array==null||array.length==0)
                return arrayList;
            while (head<end)
            {
                if (array[head]+array[end]>sum)             //大于情况，向前移动尾指针
                    end--;
                else if (array[head]+array[end]<sum)        //小于情况，向后移动头指针
                    head++;
                if (array[head]+array[end]==sum)
                {
                    arrayList.add(array[head]);
                    arrayList.add(array[end]);
                    break;
                }
            }
            return arrayList;
    }
  static   ArrayList<ArrayList<Integer> > arrayLists = new ArrayList<>();
  static   public ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum) {
      if (sum<3)
          return arrayLists;
      int small= 1;
      int big = 2;
      int middle = (sum+1)>>1;
      int curSum = small+big;

      while (small<middle)
      {
          if (curSum==sum)
              Print(small,big);
          while (curSum>sum&&small<middle)  //默认就应该是big++，因为其实位置是1,2；
          {
              curSum-=small;
              small++;
              if (curSum==sum)
                  Print(small,big);
          }
          big++;
          curSum+=big;
      }
      return  arrayLists;
    }
  static   public ArrayList<ArrayList<Integer> > FindContinuousSequence1(int sum) {
      //int middle = sum>>1;
      /*
      (an+a1) -->k
      (an-a1+1) -->n
      k*n = 2*sum
      所以k和n一定不能同时大于2*sum的开方；当a是整数范围，k，n一定不能相等
       */
      int middle = (int)Math.sqrt(2*sum);  //
      for ( int n = middle;n>=2;n--)
      {
          if ((2*sum%n)==0)
          {
              int k = sum*2/n;              //n*k = sum*2
              if ((k^n)%2==1)               //一个是奇数，一个是偶数
              {
                  int a1 = (k-n+1)/2;
                  int an = (k+n-1)/2;
                  ArrayList<Integer> arrayList= new ArrayList<>();
                  for (int i = a1; i <= an; i++) {
                      arrayList.add(i);
                  }
                  arrayLists.add(arrayList);
              }
          }
      }
      return  arrayLists;
    }


    static void Print(int small,int big)
    {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = small;i<=big;i++)
           arrayList.add(i);
        arrayLists.add(arrayList);
    }

}
