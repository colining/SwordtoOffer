package offer.fourty;

import java.util.HashMap;

/**
 * Created by asus on 2017/4/1.
 */
public class Five {
    public  static  void  main(String []arg)
    {
        String a=null;
        String a1 = "";
        String a2 = "abcdabd";
        System.out.println(FirstNotRepeatingChar(a2));
    }
   static public int FirstNotRepeatingChar(String str) {
        if (str==null||str.length()==0)
            return -1;
        char a[] = str.toCharArray();                   //这个数组是多余的内存消耗，应该写成str.charAt(index)获取当前字符
        HashMap<Character,Integer> hashMap = new HashMap();
        for (int i = 0; i < a.length; i++) {
            if (hashMap.containsKey(a[i]))                  //如果出现过
            hashMap.put(a[i],hashMap.get(a[i])+1);          //将value+1；
            else
                hashMap.put(a[i],0);
        }
       for (int i = 0; i < a.length; i++) {             //hashmap是无序的，所以要按照原字符串的顺序寻找
           if (hashMap.get(a[i])==0)
               return i+1;
       }
        return 0;
    }
}
