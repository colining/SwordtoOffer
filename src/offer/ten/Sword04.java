package offer.ten;

/**
 * Created by colin on 2017/3/16.
 */
public class Sword04 {
    /* 替换空格
    请实现一个函数，将一个字符串中的空格替换成“%20”。
    例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
     */
    public static void main(String[] arg) {
        StringBuffer b = new StringBuffer("hello world ");
        System.out.println(replaceSpace1(b));
    }

    public static String replaceSpace(StringBuffer str) {
        if (str == null || str.length() < 1)
            return "";
        /*
        char数组
         */
        char[] test = str.toString().toCharArray();
        StringBuffer b = new StringBuffer();
        for (int i = 0; i < test.length; i++) {
            if (test[i] == ' ') {
                b.append("%20");
            } else
                b.append(test[i]);
        }
        return b.toString();
    }

    public static String replaceSpace1(StringBuffer str) {
        if (str == null || str.length() < 1)
            return "";
        /*
        直接利用charAt()

         */
        StringBuilder b = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                //b.append("%20"); 添加字符串和添加字符效率不一样
                b.append('%');
                b.append('2');
                b.append('0');
            } else
                b.append(str.charAt(i));
        }
        return b.toString();
    }

    public static String replaceSpace2(StringBuffer str) {
        if (str == null || str.length() < 1)
            return null;
        /*
        调用库函数，可能有很多人和我一样，根本不知道String库函数是啥
         */
//        return new StringBuffer(str.toString().replaceAll(" ", "%20"));
        return str.toString().replaceAll("\\s", "%20");
    }

    public static String replaceSpace3(StringBuffer str) {
        /*
        剑指offer的解法，两次遍历
         */
        if (str == null || str.length() < 1)
            return "";
        //获得空格总数
        int numofspace = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ')
                numofspace += 2;
        }
        //开始迁移字符串并且添加字符
        char[] a = new char[str.length() + numofspace];
        int index = str.length() - 1;
        int indexnew = a.length - 1;
        for (; index >= 0; index--) {
            if (str.charAt(index) == ' ') {
                a[indexnew--] = '0';
                a[indexnew--] = '2';
                a[indexnew--] = '%';
            } else {
                a[indexnew--] = str.charAt(index);
            }
        }

        return new String(a);
    }

}
