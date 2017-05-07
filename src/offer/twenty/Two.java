package offer.twenty;

import java.util.Arrays;

/**
 * Created by asus on 2017/3/21.
 */
public class Two {
    public  static  void  main(String [] arg)
    {
//        Print(2);
        PermutationSequence(2);
    }
   static void Print(int n)
    {
        if ( n<=0)
            return;
        char [] number = new char[n];
        for (int i = 0 ; i <10;++i)
        {
            number[0]= (char) (i+'0');
            PrintTm(number,n,0);
        }

    }
    static void  PrintTm(char[] number , int length , int index)
    {
        if (index == length - 1 )
        {
            PrintNumber(number);
            return;
        }
        for (int i = 0 ; i< 10 ;++i)
        {
            number[index+1] = (char) (i+'0');
            PrintTm(number,length,index+1);
        }
    }
    static   void  PrintNumber(char [] number)
    {
        boolean isBegin0 = true;
        for (int i = 0 ; i <number.length; ++i)
        {
            if (isBegin0&&number[i]!='0')
                isBegin0=false;
            if (!isBegin0)
            {
                System.out.print(number[i]);
            }

        }
        System.out.println();
    }
    static void PermutationSequence (int n)
    {
        int ps[] = new int[n];
        solution(ps,0);
    }
    static void solution(int ps[], int index)
    {
        if (index==ps.length)
        {
            System.out.println(Arrays.toString(ps));
            return;
        }
        for (int i = 0 ; i<10;i++)
        {
            ps[index]=i;
            solution(ps,index+1);
        }
    }


}
