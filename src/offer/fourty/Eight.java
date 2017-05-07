package offer.fourty;

/**
 * Created by asus on 2017/4/2.
 */
public class Eight {
    public  static  void  main(String []arg)
    {
        int a[] = {1,3,3,3,3,4,5};
        System.out.println(GetNumberOfK(a, 2));

    }
  static   public int GetNumberOfK(int [] array , int k) {
        if (array==null||array.length==0)
            return  0;
            int first =GetFirst(array,k,0,array.length-1);
            int last = GetLast(array,k,0,array.length-1);

      return (first>-1&&first>-1)?last-first+1:0;
    }
  static   public  int GetFirst(int []arr,int k ,int  start , int end)
    {
        if (start>end)
            return  -1;
        int mid = (start+end)>>1;
        if (arr[mid]==k)
        {
            if ((mid==0)||(mid>0&&arr[mid-1]!=k))
            {
                return mid;
            }
            else
                end = mid-1;
        }
        else if (arr[mid]<k)
        {
            start=mid+1;
        }
        else if (arr[mid]>k)
            end = mid-1;

        return GetFirst(arr,k,start,end);
    }
  static   public  int GetLast(int []arr,int k ,int  start , int end)
    {
            if (start>end)
                return -1;
            int mid = (start +end)>>1;
        if (arr[mid]==k)
        {
            if (mid==arr.length-1||(mid<arr.length-1&&arr[mid+1]!=k))
                return mid;
            else
                start= mid+1;
        }
        else if (arr[mid]>k)
            end=mid-1;
        else if (arr[mid]<k)
            start = mid+1;
        return GetLast(arr, k, start, end);
    }
}
