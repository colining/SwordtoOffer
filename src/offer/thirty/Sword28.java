package offer.thirty;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

/**
 * Created by asus on 2017/3/26.
 */
public class Sword28 {
    public static void main(String[] arg) {
        String a = "1234";
        Permutation(a);
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.println(arrayList.get(i));
        }
    }

    static public ArrayList<String> Permutation(String str) {           //用于进行边界判定，调用函数，以及返回结果
        if (str == null || str.length() == 0)
            return null;
        Permutation(str.toCharArray(), 0);
        Collections.sort(arrayList);
        return arrayList;
    }

    static ArrayList<String> arrayList = new ArrayList<>();
    static HashSet<String> hashSet = new HashSet<>();
    static public void Permutation(char[] str, int start)             //全排列函数
    {
        if (start == str.length - 1) {
            char a[] = Arrays.copyOf(str, str.length - 2);
            //这里使用了一下hash的特性，也可以使用下面的if
            if (hashSet.add(String.valueOf(a))) {
                arrayList.add(String.valueOf(a));
            }
        } else
            for (int j = start; j < str.length; ++j) {
                //if (iscanswap(str,start,j)){                  //可以通过判定j是否在前面出现过
                swap(str, start, j);
                Permutation(str, start + 1);
                swap(str, start, j);
            }
    }

    static public void swap(char[] str, int i, int j) {
        char temp = str[i];
        str[i] = str[j];
        str[j] = temp;
    }

    static public boolean iscanswap(char[] str, int start, int i) {
        for (int k = start; k < i; k++) {
            if (str[k] == str[i])
                return false;
        }
        return true;
    }
}
