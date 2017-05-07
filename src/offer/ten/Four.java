package offer.ten;

/**
 * Created by asus on 2017/3/16.
 */
public class Four {
    public  static  void  main(String [] arg)
    {
//        StringBuffer a =  new StringBuffer("hello world ");
//        System.out.println(Four.replaceSpace1(a));
        String b = "hello world";
        System.out.println(b.charAt(4));
    }
    public static StringBuffer replaceSpace(StringBuffer str) {
            String a = String.valueOf(str);
            char [] test = a.toCharArray();
            StringBuffer b = new StringBuffer();

        for (int i = 0 ; i<test.length;i++)
        {

            if (test[i]==' ')
            {
               b.append("%20");
            }
            else
            b.append(test[i]);
        }

        return b;
    }
    public static StringBuilder replaceSpace1(StringBuffer str) {

            StringBuilder b= new StringBuilder();
        for (int i = 0 ; i<str.length();i++)
        {

            if (str.charAt(i)==' ')
            {
                //b.append("%20");
                b.append('%');
                b.append('2');
                b.append('0');
            }
            else
                b.append(str.charAt(i));
        }

        return b;
    }

}
