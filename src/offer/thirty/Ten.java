package offer.thirty;

import java.util.ArrayList;
import java.util.TreeSet;

/**
 * Created by asus on 2017/3/29.
 */
public class Ten {
    public  static  void  main(String [] arg)
    {
            int [] n=null;
            int [] n1 ={4,5,1,6,2,7,3,8};
            int [] n2 = {8,5,3,2,1,5};
        ArrayList arrayList =new ArrayList();
       arrayList= (GetLeastNumbers_Solution1(n,4));
      arrayList=  GetLeastNumbers_Solution1(n1,10);
      arrayList=  GetLeastNumbers_Solution2(n2,4);
        System.out.println("allla");
    }
    static public ArrayList<Integer> GetLeastNumbers_Solution1(int [] input, int k)
    {
        ArrayList arrayList= new ArrayList();
        if (input==null||k<=0||k>input.length||input.length<=0)
            return arrayList;
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int i = 0; i < input.length; i++) {
            treeSet.add(input[i]);
        }
        for (int i=0;i<k;i++)
        {
            arrayList.add(treeSet.pollFirst());
        }
        return  arrayList;
    }
    static public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList arrayList= new ArrayList();
        if (input==null||k<=0||k>input.length||input.length<=0)
                return arrayList;
        int left = 0;
        int right = input.length-1;
        int index =AdujustArray(input,left,right);
        while (index!=k-1)
        {
            if (index<k-1) {
                left = index + 1;
                index=AdujustArray(input,left,right);
            }
            else
            {
                right =index-1;
                index= AdujustArray(input,left,right);
            }

        }
        for (int i = 0 ; i<k;i++)
        {
            arrayList.add(input[i]);
        }
        return arrayList;
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
    static public ArrayList<Integer> GetLeastNumbers_Solution2(int [] input, int k)
    {
        ArrayList arrayList= new ArrayList();
        if (input==null||k<=0||k>input.length||input.length<=0)
            return arrayList;
        int [] array = BuildMaXHeap(input);
        for (int i = array.length-1;i>array.length-1-k;i--)
        {
            int temp = array[0];
            array[0]=array[i];
            array[i]= temp;
            arrayList.add(temp);
            AdjustMaxHeap(array,0,i);
        }
        return  arrayList;

    }
    static   public  int [] BuildMaXHeap(int []array)
    {
        /*
        大根堆如果从一开始计数，ki就是k2i,k(2i+1)的父节点；
        但是数组是从零计数的，个数就是数组长度，父节点下标就是/2再减去一；
         */
        for (int i=(array.length-2)/2;i>=0;i--)
        {
            AdjustMaxHeap(array,i,array.length);
        }
        return  array;
    }
    static    public void  AdjustMaxHeap(int []array , int k,int length)
    {
        int temp = array[k];                            //当前要调整的父节点
        /*
         j是他的子节点，如果继续循环，说明当前节点已经向下移动了了一层
         */
        for (int j=2*k+1;j<length-1;j=2*k+1)
        {
            if (j<length&&array[j]>array[j+1])            //如果右节点比左节点大，就变化下标
            {
                j++;
            }
            if (temp<=array[j])                                 //父节点大于当前子节点的最大值，说明这个父节点为首的大根堆没有问题
                break;
            else {
                array[k] = array[j];
                k = j;                    //记录父节点更换到的位置，继续下一次的循环
            }
        }
        array[k]= temp;                   //父节点可能会有多次移动，所以最后一次移动结束。再赋值

    }
}
