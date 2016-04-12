package practice.SnakeMatrix;

/**
 * Created by Jason on 2016/4/12.
 */
public class SnakeMatrix {

    private int size;
    private int[][] matrix;

    public SnakeMatrix(int size) {
        this.size = size;
        matrix = new int[size][size];
         for (int i=0;i<size;i++) {
             for (int j=0;j<size;j++) {
                 matrix[i][j] = i*size + j + 1;
             }
         }
    }

    public void output() {
        int left = 0, top = 0, right = size - 1, bottom = size - 1;
        int i = 0, j = 0;
        while (i>=top&&i<=bottom&&j>=left&&j<=right) {
            char direction = getDirection(i,j,left,top,right,bottom);
            switch (direction) {
                case 'r'://right
                    while (j<=right) {
                        System.out.print(matrix[i][j++] + " ");
                    }
                    j--;
                    i++;
                    top++;
                    break;
                case 'd'://down
                    while (i<=bottom) {
                        System.out.print(matrix[i++][j]+" ");
                    }
                    i--;
                    j--;
                    right--;
                    break;
                case 'l'://left
                    while (j>=left) {
                        System.out.print(matrix[i][j--]+" ");
                    }
                    j++;
                    i--;
                    bottom--;
                    break;
                case 'u'://up
                    while (i>=top) {
                        System.out.print(matrix[i--][j]+" ");
                    }
                    i++;
                    j++;
                    left++;
                    break;
            }
            System.out.println();
            //System.out.println(i+" "+j+" "+left+" "+top+" "+right+" "+bottom);
        }
    }

    private char getDirection(int i, int j, int left, int top, int right, int bottom) {

        if (i==0&&j==0) {
            return 'r';
        }
        if (i==top&&j==left) {
            return 'r';
        } else if (i==top&&j==right) {
            return 'd';
        } else if (i==bottom&&j==right) {
            return 'l';
        } else  {
            return 'u';
        }
    }

    public static void main(String[] args) {
        SnakeMatrix snakeMatrix = new SnakeMatrix(4);
        snakeMatrix.output();
    }

}
