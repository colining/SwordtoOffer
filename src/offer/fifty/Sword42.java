package offer.fifty;

/**
 * Created by colin on 2017/4/5.
 */
public class Sword42 {
    /* 左旋字符串
    对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。
    例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，
    即“XYZdefabc”。是不是很简单？OK，搞定它！
     */
    public static void main(String[] arg) {
//左旋
        String a = null;
        int n1 = -1;
        String a1 = "abcXYZdef";
        int n2 = 9;
        System.out.println(LeftRotateString2(a1, n2));

//反转单词
//       String str1 = "abc";
//       System.out.println(Reverse(str1, 0, str1.length()-1));
//       String student = "I am DoesTreeHaveTree Student.";
//       System.out.println(student.charAt(1));
//       System.out.println(ReverseSentence(student));
    }

    /*
    左旋字符串
     */
    static public String LeftRotateString1(String str, int n) {
        if (str == null)
            return null;
        if (n == 0 || str.length() == 0)
            return str;
        n = n > str.length() ? n % str.length() : n;            //判定实际上要左旋多少位
        String a = str.substring(0, n);                         //字符串截取
        String b = str.substring(n, str.length());              //字符串截取
        return b + a;
    }

    static public String LeftRotateString2(String str, int n) {
        if (str == null)
            return null;
        if (n == 0 || str.length() == 0)
            return str;
        n = n % str.length();
        str += str;
        str = str.substring(n, str.length() / 2 + n);
        return str;
    }

    static public String LeftRotateString3(String str, int n) {
        if (str == null || str.length() == 0)
            return null;

        n = n % str.length();
        if (n <= 0)
            return str;
        int begin = 0;
        int end = str.length() - 1;
        str = Reverse(str, begin, n - 1);
        str = Reverse(str, n, end);
        str = Reverse(str, begin, end);
        return str;
    }

    static String Reverse(String str, int begin, int end) {
        if (str == null || begin > end || begin < 0 || end < 0)
            return null;
        char[] array = str.toCharArray();
        char temp;
        while (begin < end)   //简单的反转单个字符
        {
            temp = array[begin];
            array[begin] = array[end];
            array[end] = temp;
            begin++;
            end--;
        }
        str = String.valueOf(array);
        return str;
    }

    /*
    反转单词，将字符串中的单词反转，空格不变
    */
    static public String ReverseSentence(String str) {
        if (str == null || str.length() == 0)
            return "";
        int begin = 0;
        int end = str.length() - 1;
        str = Reverse(str, begin, end);
        end = begin;
        while (begin < str.length() - 1) {
            if (str.charAt(begin) == ' ')   //遇见空格，跳过
            {
                begin++;
                end++;
            }
            //最后一个单词时，end指向的不是空格，而是末尾，这样就搜索到
            //了一个单词，或者就是遇到空格，也就得到了一个单词；
            else if ((end == str.length()) || str.charAt(end) == ' ') {
                str = Reverse(str, begin, --end);
                begin = ++end;                  //将begin重新指向一个新单词的开始；
            } else                              //平常end指针就狂加，
            {                                   //但是begin还在一个单词的起始位置停留
                end++;
            }
        }
        return str;
    }
}
