package offer.thirty;

/**
 * Created by asus on 2017/3/27.
 */
public class S_28 {
    public static int count = 0;

    public static void main(String[] args) {
        char[] list = {'a', 'b', 'c'};
        char[] list1 = {'a', 'b', 'b'};
        //permutation(list);
        permutation(list1);
        System.out.println("all numbers: " + count);
    }

    public static void permutation(char list[]) {
        if (list == null)
            return;
        else
            permutation(list, 0, list.length - 1);
    }

    private static void permutation(char[] list, int start, int end) {
        if (start == end) {
            //System.out.println(list);
            for (int i = 0; i <= end; i++) {

                System.out.print(list[i]);

            }
            count++;

            System.out.println();
        } else {
            for (int i = start; i <= end; ++i) {
                if (isSwap(list, start, i)) {
                    Swap(list, start, i);
                    permutation(list, start + 1, end);
                    Swap(list, start, i);

                }
            }
        }
    }

    public static void Swap(char list[], int i, int j) {
        char temp = list[i];
        list[i] = list[j];
        list[j] = temp;
    }

    //判断当前"i"处的字符是否之前已经出现过，出现过则返回false，不交换
    private static boolean isSwap(char[] list, int start, int i) {
        for (int k = start; k < i; k++)
            if (list[k] == list[i])
                return false;
        return true;
    }
}
