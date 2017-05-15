package offer.sixty;

/**
 * Created by colin on 2017/4/9.
 */
public class Sword53 {
    /* 正则表达式匹配
    请实现一个函数用来匹配包括'.'和'*'的正则表达式。
    模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（包含0次）。
    在本题中，匹配是指字符串的所有字符匹配整个模式。
    例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
     */
    public static void main(String[] arg) {
        String a = "DoesTreeHaveTree";
        String b = "ab*DoesTreeHaveTree";
        System.out.println(match(a.toCharArray(), b.toCharArray()));
    }

    static public boolean match(char[] str, char[] pattern) {
        if (str == null || pattern == null)
            return false;
        return matchCore(str, 0, pattern, 0);
    }

    static public boolean matchCore(char[] str, int s, char[] pattern, int p) {
        if (str.length <= s && pattern.length <= p)
            return true;
        if (str.length > s && pattern.length <= p)
            return false;

        //当前字符的后面是*号
        if (p + 1 < pattern.length && (pattern[p + 1] == '*')) {

            if (s >= str.length) {                                  //str可能会超出范围，这时直接模式后移
                return matchCore(str, s, pattern, p + 2);

            } else {
                if (pattern[p] == str[s] || pattern[p] == '.') {    //当前字符相同
                    return matchCore(str, s + 1, pattern, p + 2)    //匹配字符下一个和*以后的
                            || matchCore(str, s + 1, pattern, p)    //*可能代表多个字符
                            || matchCore(str, s, pattern, s + 2);   //当前字符虽然相等，但可能应该匹配的是*以后的；
                } else
                    return matchCore(str, s, pattern, p + 2);       //当前不匹配，那自然往后找了
            }
        }

        if (s >= str.length) return false;
        else {
            if (str[s] == pattern[p] || pattern[p] == '.')
                return matchCore(str, s + 1, pattern, p + 1);
        }
        return false;
    }
}
