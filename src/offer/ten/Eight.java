package offer.ten;

/**
 * Created by asus on 2017/3/20.
 */
public class Eight {
    public  static  void  main (String [] arg)
    {
        int a [] = {6,1,2,3,4,5};
        System.out.println(minNumberInRotateArray(a));
    }

      static   public int minNumberInRotateArray(int [] array) {

            return solution2(array);
            //return  solution(array);
        }
      static   int solution (int [] array)
        {
            if (array.length==0)
                return  0;
            int a = array[0];
            for(int i = 1;i<array.length;i++)
            {
                if (array[i]<a)
                {
                    a=array[i];
                }
            }
            return a;
        }
      static   int solution2 (int [] array)
        {
            if (array.length==0)                            //����û��Ԫ�أ�����0
            return  0;
            int start = 0;
            int end = array.length-1;
            int mid=start;
            while (array[start]>=array[end])
            {
                if (end-start == 1)
                {
                    mid = end;
                    break;
                }
                mid = (start+end)/2;
                if (array[start]==array[mid]&&array[mid]==array[end])
                {
                   return MinOrder(array,start,end);
                }
                if (array[mid]>=array[start])
                    start = mid;
                else if (array[mid]<=array[end])
                    end=mid;
            }
            return  array[mid];

        }
        static  int MinOrder( int array[] , int start, int end) {
            int result = array[start];
            for (int i = start + 1; i <= end; ++i)
            {
                if ( result>array[i])
                    result  = array[i];
            }
            return  result;
        }

}
