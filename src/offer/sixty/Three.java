package offer.sixty;

/**
 * Created by asus on 2017/4/9.
 */
public class Three {
    public  static  void  main(String []arg)
    {
        String a = "a";
        String b = "ab*a";
        System.out.println(match(a.toCharArray(), b.toCharArray()));
    }
    static public boolean match(char[] str, char[] pattern)
    {
        if(str==null||pattern==null) return false;

        return matchCore(str,0,pattern,0);
    }

    static public boolean matchCore(char[] str,int s, char[] pattern,int p) {
        if (str.length<=s &&pattern.length<= p)
            return  true;
        if (str.length>s&&pattern.length<=p)
            return false;

        //当前字符的后面是*号
        if (p+1<pattern.length&& (pattern[p+1]=='*'))
        {

            if (s>=str.length) {            //str可能会超出范围，这时直接模式后移
                System.out.println("la");
                return matchCore(str, s, pattern, p + 2);

            }
            else {
                if (pattern[p] == str[s] || pattern[p] == '.') {    //当前字符相同
                    return matchCore(str, s + 1, pattern, p + 2)    //匹配字符下一个和*以后的
                            || matchCore(str, s + 1, pattern, p)    //*可能代表多个字符
                            || matchCore(str, s, pattern, s + 2);   //当前字符虽然相等，但可能应该匹配的是*以后的；
                } else
                    return matchCore(str, s, pattern, p + 2);       //当前不匹配，那自然往后找了
            }
        }

        if (s>= str.length) return  false;
        else
        {
            if ( str[s] == pattern[p]||pattern[p]=='.')
                return matchCore(str,s+1,pattern,p+1);
        }
        return  false;
    }
}
