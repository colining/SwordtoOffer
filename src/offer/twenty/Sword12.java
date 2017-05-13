package offer.twenty;

import java.util.Arrays;

/**
 * Created by colin on 2017/3/21.
 */
public class Sword12 {
    /*
    打印1到最大的 n 位数
     */
    public static void main(String[] arg) {
        PermutationSequence1(1);
    }

    static void PermutationSequence1(int n) {
        if (n <= 0)
            return;
        char[] number = new char[n];
        PrintTm(number, n, 0);
    }

    static void PrintTm(char[] number, int length, int index) {
        if (index > length - 1) {
            PrintNumber(number);
            return;
        }
        for (int i = 0; i < 10; ++i) {
            number[index] = (char) (i + '0');
            PrintTm(number, length, index + 1);
        }
    }

    static void PrintNumber(char[] number) {
        boolean isBegin0 = true;
        for (int i = 0; i < number.length; ++i) {
            //判断首位是不是0
            if (isBegin0 && number[i] != '0')
                isBegin0 = false;
            //判定是否需要换行
            if (isBegin0 && i == number.length - 1)
                return;
            if (!isBegin0) {
                System.out.print(number[i]);
            }
        }
        System.out.println();
    }


    static void PermutationSequence2(int n) {
        int number[] = new int[n];
        solution(number, 0);
    }

    static void solution(int number[], int index) {
        if (index == number.length) {
            System.out.println(Arrays.toString(number));
            return;
        }
        for (int i = 0; i < 10; i++) {
            number[index] = i;
            solution(number, index + 1);
        }
    }


}
