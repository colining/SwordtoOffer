package offer.sixty;

/**
 * Created by colin on 2017/4/9.
 */
public class Sword55 {
    /* 字符流中第一个不重复的字符
    请实现一个函数用来找出字符流中第一个只出现一次的字符。例如，
    当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。
    当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
     */
    public static void main(String[] arg) {

    }

    /*
    核心想法就是通过一个数组完成检测重复；
     */
    int[] hash = new int[256];
    StringBuilder s = new StringBuilder();

    public void Insert(char ch) {
        hash[ch]++;
        s.append(ch);
    }

    public char FirstAppearingOnce() {

        for (char c : s.toString().toCharArray()) {
            if (hash[c] == 1)
                return c;
        }

        return '#';
    }
}
