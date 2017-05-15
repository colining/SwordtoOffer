package offer.sixty;

/**
 * Created by asus on 2017/4/9.
 */
public class Sword52 {
    /* 构建乘积数组
    给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],
    其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。
     */
    public static void main(String[] arg) {

    }

    public int[] multiply(int[] A) {
        //没啥可解释的，
        int length = A.length;
        int[] C = new int[length];
        int[] D = new int[length];
        int[] B = new int[length];
        C[0] = 1;
        D[0] = 1;
        for (int i = 1; i < length; i++) {
            C[i] = A[i - 1] * C[i - 1];
            D[i] = A[length - i] * D[i - 1];
        }
        for (int i = 0; i < length; i++) {
            B[i] = C[i] * D[length - i - 1];
        }
        return B;
    }
}
