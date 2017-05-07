package offer.ten;

/**
 * Created by asus on 2017/3/16.
 */
public class Three {
    public  static  void  main(String [] arg)
    {
        //int a[] []= {{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
        int a[][] = {{1,2,8,9},{2,4,9,12}};
        //int a [][] = new int[2][2];
        int b=8;
        System.out.println(Three.Find(b,a));

    }
    public static boolean Find(int target, int [][] array) {
        int  Row = array.length-1;
        int Columm = array[0].length-1;

        for (int a = Columm; a >= 0; a--) {
                if (target >= array[0][a]) {
                    for (int b = 0; b<=Row;b++)
                    {
                        if (target==array[b][a])
                            return true;
                    }
                }
            }
        return  false;
    }
}
