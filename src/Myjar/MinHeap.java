package Myjar;

import java.util.Arrays;

/**
 * Created by asus on 2017/3/30.
 */
public class MinHeap {
    public  static  void  main(String [] arg)
    {
        int []a ={87,8,122,133};
        System.out.println(Arrays.toString(heapSort(a)));
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
    static public int[] heapSort(int[] array){
        array = BuildMaXHeap(array); //初始建堆，array[0]为第一趟值最大的元素
        for(int i=array.length-1;i>0;i--){
            int temp = array[0];  //将堆顶元素和堆低元素交换，即得到当前最大元素正确的排序位置
            array[0] = array[i];
            array[i] = temp;
            AdjustMaxHeap(array, 0,i);  //整理，将剩余的元素整理成堆,由于i变小了，所以大根堆得调整就不包括已经得到的最大元素了
        }
        return array;
    }
}

