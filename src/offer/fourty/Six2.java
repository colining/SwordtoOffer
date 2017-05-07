package offer.fourty;

import java.util.Arrays;

/**
 * Created by asus on 2017/4/1.
 */
public class Six2 {
    public static void  main(String []arg)
    {
        int a[] = {364,637,341,406,747,995,234,971,571,219,993,407,416,366,315,301,601,650,418,355,460,505,360,965,516,648,727,667,465,849,455,181,486,149,588,233,144,174,557,67,746,550,474,162,268,142,463,221,882,576,604,739,288,569,256,936,275,401,497,82,935,983,583,523,697,478,147,795,380,973,958,115,773,870,259,655,446,863,735,784,3,671,433,630,425,930,64,266,235,187,284,665,874,80,45,848,38,811,267,575};
        System.out.println(InversePairs(a));
    }
   static public int InversePairs(int [] array) {
        int [] result = new int[array.length];
       for (int i = 0; i < array.length; i++) {
           result[i] = array[i];
       }
        int a= Merge(array, result, 0, array.length - 1)%1000000007;
       System.out.println(Arrays.toString(result));
       return a;
    }
   static public   int Merge(int [] arr,int [] result,int start , int end)
    {
        if (start==end)
        {
            result[start]= arr[start];
            return 0;
        }
        int lengh = (end-start)>>1;
        int mid = start + lengh;
        int left = Merge(result,arr,start,mid)%1000000007;
        int right = Merge(result,arr,mid+1,end)%1000000007;

        int leftend = mid;
        int rightend = end;
        int index = end;
        int count = 0;
        while (leftend>=start&&rightend>mid)
        {
            if (arr[leftend]>arr[rightend])
            {
                result[index--]=arr[leftend--];
                count+= rightend-mid;
                if(count>=1000000007)//数值过大求余
                {
                    count%=1000000007;
                }
            }
            else
                result[index--]=arr[rightend--];
        }
        for (;leftend>=start ; --leftend)
        {
            result[index--]=arr[leftend];
        }
        for (;rightend>=mid+1;--rightend)
        {
            result[index--] = arr[rightend];
        }
//        for (int i = start; i <=end;i++)
//        {
//            arr[i]=result[i];
//        }
        return  (count+left+right)%1000000007;
    }
}
