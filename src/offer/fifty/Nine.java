package offer.fifty;

/**
 * Created by asus on 2017/4/9.
 */
public class Nine {
    public static  void  main(String []arg)
    {
        String a = "-11";
        System.out.println(StrToInt(a));
    }

    static public int StrToInt(String str) {
        if (str==null||str.length()==0)                 //null和空字符串检验
            return 0;
        char [] a = str.toCharArray();                  //消耗点空间呗
        if (a[a.length-1]<'0'||a[a.length-1]>'9')       //检查最后一个字符是否不是数字
            return 0;
        boolean flag = true;                            //加法还是减法
        int number=0;                                   //假发或者减法第二项
        int result = 0;                                 //结果
        for (int i = 0; i < a.length;i++) {             //写的难看的for循环

            while (a[i]!='+'&&a[i]!='-') {              //计算第二项
                if (a[i]>'9'||((a[i]<'0')&&(a[i]!='+'||a[i]!='-')))//检测
                    return 0;
                number = number * 10 + a[i] - '0';
                i++;
                if (i>a.length-1)
                    break;
            }
            if (i>=a.length-1)                          //到尾了
            {
                if (flag)                               //flag用于判断前一个符号是+还是-
                    result += number;
                else if (flag==false)
                    result-=number;
                break;
            }
            if (i<a.length&&a[i]=='+')
            {
                if (flag)
                    result += number;
                else if (flag==false)
                    result-=number;
                flag = true;
                number = 0;

            }
            if (i<a.length&&a[i]=='-')
            {
                if (flag)
                    result += number;
                else if (flag==false)
                    result-=number;
                flag = false;
                number = 0;
            }
        }
        return result;
    }
}
