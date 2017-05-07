package offer.sixty;

/**
 * Created by asus on 2017/4/9.
 */
public class Two {
    public  static  void  main(String [] arg)
    {

    }
    public int[] multiply(int[] A) {
        int length = A.length;
        int [] C = new int[length];
        int [] D = new int[length];
        int [] B = new int[length];
        C[0] = 1;
        D[0] = 1;
        for (int i = 1; i < length; i++) {
            C[i] = A[i-1] * C[i-1];
            D[i] = A[length-i] *D[i-1];
        }
        for (int i = 0; i < length; i++) {
            B[i] = C[i] * D[length-i-1];
        }
        return  B;
    }
}
