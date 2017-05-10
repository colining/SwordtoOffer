package offer.thirty;

/**
 * Created by asus on 2017/3/26.
 */
public class Four {
    public  static  void  main(String [] arg)
    {
                    int []a= {4,8,6,12,16,14,10};
        //System.out.println(DoesTreeHaveTree.length);
        System.out.println(Vs(a));
    }
    static public boolean VerifySquenceOfBST(int [] sequence) {
       if (sequence==null||sequence.length<=0)
           return false;
        boolean flag = false;
        int i = 0,j;
        for (; i <sequence.length-1;i++)
        {
            if (sequence[i]>sequence[sequence.length-1])
                break;
        }
        for (j=i;j<sequence.length-1;j++)
        {
            if (sequence[j]<sequence[sequence.length-1])
                return false;
        }
        boolean left = true;
       if (i>0) {
           int leftarray[] = new int[i];
           System.arraycopy(sequence, 0, leftarray, 0, i);
           left = VerifySquenceOfBST(leftarray);
       }
        boolean right=true ;
       if (i<sequence.length-1) {
           int rightarray[] = new int[sequence.length - i-1];
           System.arraycopy(sequence, 0, rightarray, 0, sequence.length - i-1);
           right = VerifySquenceOfBST(rightarray);
       }
        return left&&right;
    }
    static  public  boolean Vs(int [] sequence)
    {
        int size = sequence.length;
        if (size==0)
            return false;

        int i = 0;
        while (--size>=0)
        {
                while (sequence[i++]<sequence[size]);
                while (i<size&&sequence[i++]>sequence[size]);
                    if (i<size)
                        return false;
            i=0;
        }
        return true;
    }

}
