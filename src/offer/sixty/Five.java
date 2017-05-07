package offer.sixty;

/**
 * Created by asus on 2017/4/9.
 */
public class Five {
    public  static  void  main(String []arg)
    {

    }
    int [] hash = new int[256];
    StringBuilder s = new StringBuilder();
    public void Insert(char ch)
    {
        hash[ch]++;
        s.append(ch);
    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce()
    {

        for (char c : s.toString().toCharArray())
        {
            if (hash[c]==1)
                return c;
        }

        return '#';
    }
}
