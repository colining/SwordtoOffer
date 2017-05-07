package offer.thirty;

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
