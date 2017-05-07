package offer.fifty;

/**
 * Created by asus on 2017/4/5.
 */
public class Two {
    public  static  void  main(String []arg)
    {
//左旋
        String a = null;
        int n1 = -1;
        String a1 = "abcXYZdef";
        int n2 = 9;
        System.out.println(LeftRotateString2(a1, n2));

//反转单词
//       String str1 = "abc";
//       System.out.println(Reverse(str1, 0, str1.length()-1));
//       String student = "I am a Student.";
//       System.out.println(student.charAt(1));
//       System.out.println(ReverseSentence(student));
    }
    /*
    左旋字符串
     */
    static   public String LeftRotateString(String str,int n) {
        if (str==null)
            return  null;
        if (n==0||str.length()==0)
            return  str;
        n=n>str.length()?n%str.length():n;
        String a = str.substring(0,n);
        String b = str.substring(n,str.length());
        return  b+a;
    }
    static   public String LeftRotateString1(String str , int n) {
        if (str==null)
            return  null;
        if ( n==0||str.length()==0)
            return str;
        n=n%str.length();
        str+=str;
       str = str.substring(n,str.length()/2+n);
        return  str;
    }
    static   public String LeftRotateString2(String str , int n){
        if (str==null||str.length()==0)
            return null;

        n=n%str.length();
        if (n<=0)
            return str;
        String strback = str;
        int begin = 0;
        int end = str.length()-1;
        str=Reverse(str,begin,n-1);
        str=Reverse(str,n,end);
        str = Reverse(str,begin,end);
        return str;
    }

    static String  Reverse (String str, int begin,int end)
    {
        if (str==null||begin>end||begin<0||end<0)
            return null;
        char [] a = str.toCharArray();
        char temp;
        while (begin<end)   //简单的反转单个字符
        {
            temp = a[begin];
            a[begin] = a[end];
            a[end] = temp;
            begin++;
            end--;
        }
        str = String.valueOf(a);
        return str;
    }
    /*
    反转单词
    */
    static public String ReverseSentence(String str) {
        if (str==null||str.length()==0)
            return "";
        int begin = 0;
        int end = str.length()-1;
        String strbackups = str;
        str = Reverse(str,begin,end);
        end =begin;
        while (begin<str.length()-1)
        {
            if (str.charAt(begin)==' ')   //遇见空格，跳过
            {
                begin++;
                end++;
            }

            else  if ((end ==str.length())||str.charAt(end) ==' ' )
            {
                str = Reverse(str,begin,--end);
                begin = ++end;
            }

            else                            //平常end指针就狂加；
            {
                end++;
            }
        }
        return  str;
    }
}
