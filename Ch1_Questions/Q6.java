/*------------------------------------------------------------------------------------------
* Q6: Given an image represented by an N*N matrix, where each pixel in the image is 4 bytes,
*     write a method to rotate the image by 90 degree. Can you do this in place.
*------------------------------------------------------------------------------------------*/

public class Q6
{
    public static void rotate(int[][] matrix, int n)
    {
        for (int layer = 0; layer < n/2; layer++)
        {
            int first = layer;
            int last = n - 1 - layer;
            
            for (int i = first; i < last; i++)
            {
                int offset = i - first;
                
                // save top
                int top = matrix[first][i];

                // left -> top
                matrix[first][i] = matrix[last-offset][first];

                // bottom -> left
                matrix[last-offset][first] = matrix[last][last-offset];

                // right -> bottom
                matrix[last][last-offset] = matrix[i][last];

                // top -> right
                matrix[i][last] = top;
            }
        }
    }   

    public static void main(String[] args)
    {
        int[][] matrix = {{1,2},{3,4}};

        rotate(matrix, 2);
        for (int j = 0; j < 2; j++)
        {
            for (int i = 0; i < 2; i++)
            {
                System.out.print(matrix[j][i]);
            }
            System.out.println();
        }
    }
}
