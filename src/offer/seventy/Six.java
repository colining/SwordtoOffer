package offer.seventy;

/**
 * Created by asus on 2017/5/6.
 */
public class Six {
    public static void main(String[] args) {
        char [] matrix = new String("ABCEHJIGSFCSLOPQADEEMNOEADIDEJFMVCEIFGGS").toCharArray();
        char [] str = new String("SGGFIECVAASABCEHJIGQEM").toCharArray();
        System.out.println(hasPath(matrix, 5, 8, str));
    }
    static public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        if (matrix == null || rows <= 0 || cols <= 0 || str == null)
            return false;
        boolean[] visited = new boolean[rows * cols];
        int pathlength=0;
        for (int row = 0; row < rows; ++row)
            for (int col = 0; col < cols; ++col) {
                if (hasPathCore(matrix, rows, cols, row, col, str, pathlength, visited)) {
                    return true;
                }
            }
        return false;
    }

    static private boolean hasPathCore(char[] matrix, int rows, int cols, int row, int col, char[] str, int pathlength, boolean[] visited) {
        if (pathlength == str.length)
            return true;
        boolean hasPath = false;
        if (row >= 0 && col >= 0 && row < rows && col < cols && matrix[row * cols +col] ==str[pathlength] && !visited[row*cols+col])
        {
            ++pathlength;
            visited[row*cols + col]=true;
            hasPath = hasPathCore(matrix, rows, cols, row+1, col, str, pathlength, visited)
                    ||hasPathCore(matrix, rows, cols, row, col+1, str, pathlength, visited)
                    ||hasPathCore(matrix, rows, cols, row-1, col, str, pathlength, visited)
                    ||hasPathCore(matrix, rows, cols, row, col-1, str, pathlength, visited);
            if (!hasPath)
            {
                pathlength--;
                visited[row*cols + col]=false;
            }
        }
        return hasPath;
    }

}
