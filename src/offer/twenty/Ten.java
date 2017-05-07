package offer.twenty;

import java.util.ArrayList;

/**
 * Created by asus on 2017/3/25.
 */
public class Ten {
    public  static void  main(String []arg)
    {
        int number[][] ={{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        int number1[][] = {{1},{2},{3},{4}};
        int number2[][] = {{1,2},{3,4},{5,6},{7,8}};

        System.out.println(printMatrix(number1));
    }
    static public  void  Pmi(int [][] number,int colums,int rows,int start,ArrayList<Integer> arrayList)
    {
            int endx = colums-1-start;                           //该圈的结束列
            int endy = rows - 1 -start;                          //该圈的结束行

        for (int i =start ; i<=endx;++i)                         //如果现在的位置和结束列不在一起就可以向右打印
        {
            int a=number[start][i];
            arrayList.add(a);
            //System.out.print(a+" ");
        }
        if (start<endy)                                         //现在的位置比结束行要小就向下打印
        {
            for (int i=start+1;i<=endy;++i)
            {
                int a= number[i][endx];
                arrayList.add(a);
               // System.out.print(a+" ");
            }
        }
        if (start<endx&&start<endy)                             //至少两行两列才可以
        {
            for (int i =endx-1;i>=start;--i)
            {
                int a = number[endy][i];
                arrayList.add(a);
               // System.out.print(a+" ");
            }
        }
        if (start<endx&&start<endy-1)                           //如果可以向上打印，说明里面还有圈的；
        {
            for (int i= endy-1;i>=start+1;--i)
            {
                int a = number[i][start];
                arrayList.add(a);
                //System.out.print(a+" ");
            }
        }
    }

   static public ArrayList<Integer> printMatrix(int [][] matrix) {

       if (matrix==null)                                        //数组为null
           return null;
       ArrayList<Integer> arrayList = new ArrayList<>();
       int colums = matrix[0].length;
       int rows = matrix.length;
       int start = 0 ;
       while (colums>start*2&&rows>start*2)                     //最终的圈应该在中间，所以乘以2应该小于行和列
       {
           Pmi(matrix,colums,rows,start,arrayList);             //进行当前圈的循环
           ++start;
       }
        return  arrayList;

    }
}
