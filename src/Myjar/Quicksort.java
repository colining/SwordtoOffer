package Myjar;

import java.util.Arrays;

/**
 * Created by asus on 2017/3/27.
 */
 public class Quicksort {
    public  static  void  main(String [] arg)
    {
        int a[] = {4,3,5,8,2,5,0,9};
        System.out.println(Arrays.toString(quick_sort1(a, 0, a.length - 1)));
    }

    public  static  int AdujustArray(int array[], int left , int right)
   {
       int left1 =left;
        int right1= right;
        int key = array[left];
       while (left1<right1)
       {
           while (array[right1]>=key&&left1<right1)
           right1--;
           if (left1<right1) {
               array[left1] = array[right1];
               left1++;
           }

           while (array[left1]<key&&left1<right1)
           left1++;
           if (left1<right1) {
               array[right1] = array[left1];
               right1--;
           }
       }
       array[left1]=key;
        return left1;
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
