package offer.fourty;

import java.util.HashMap;

/**
 * Created by colin on 2017/4/1.
 */
public class Sword35 {
    /* 第一个只出现一次的字符
    在一个字符串(1<=字符串长度<=10000，全部由大写字母组成)中找到第一个只出现一次的字符,并返回它的位置
     */
    public static void main(String[] arg) {
        String a = null;
        String a1 = "";
        String a2 = "abcdabd";
        System.out.println(FirstNotRepeatingChar(a2));
    }

    static public int FirstNotRepeatingChar(String str) {
        if (str == null || str.length() == 0)
            return -1;
        char array[] = str.toCharArray();                       //这个数组是多余的内存消耗，应该写成str.charAt(index)获取当前字符
        HashMap<Character, Integer> hashMap = new HashMap();
        for (int i = 0; i < array.length; i++) {
            if (hashMap.containsKey(array[i]))                         //如果出现过
                hashMap.put(array[i], hashMap.get(array[i]) + 1);          //将value+1；
            else
                hashMap.put(array[i], 0);
        }
        for (int i = 0; i < array.length; i++) {             //hashmap是无序的，所以要按照原字符串的顺序寻找
            if (hashMap.get(array[i]) == 0)
                return i + 1;
        }
        return 0;
    }
}
