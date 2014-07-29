/*------------------------------------------------------------------------------------------
* Q7: Write an algorithm such that if an element in an M*N matrix is 0, its entire row and 
*     column are set to 0
*-----------------------------------------------------------------------------------------*/

public class Q7
{
    public static void setZeros(int[][] matrix)
    {
        boolean[] row = new boolean[matrix.length];
        boolean[] column = new boolean[matrix[0].length];

        // Store the row and column index with value 0
        for (int i = 0; i < matrix.length; i++)
        {
            for (int j = 0; j < matrix[0].length; j++)
            {
                if (matrix[i][j] == 0)
                {
                    row[i] = true;
                    column[j] = true;
                }
            }
        }

        // set arr[i][j] to 0 if either row i or column j has a 0
        for (int i = 0; i < matrix.length; i++)
        {
            for (int j = 0; j < matrix[0].length; j++)
            {
                if (row[i] || column[j])
                    matrix[i][j] = 0;
            }
        }
    }

    public static void main(String[] args)
    {
        int[][] matrix = {{1,2,3,4},{5,2,0,8},{5,1,7,0},{0,1,1,1}};

        for (int i = 0; i < matrix.length; i++)
        {
            for (int j = 0; j < matrix[0].length; j++)
            {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        setZeros(matrix);

        for (int i = 0; i < matrix.length; i++)
        {
            for (int j = 0; j < matrix[0].length; j++)
            {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
