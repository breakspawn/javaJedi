import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;

public class Main
{



    public static void main(String[] args)
    {

            arrays();
            matrix();
    }

    public static void matrix(){
        int[][] matrix;
        int size = 3;
        matrix = new int[3][3];
          for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = randomInt();
                System.out.print(matrix[i][j] + " ");
            }

        }
    }

    public static int randomInt()
    {
        Random random = new Random();
        int a = random.nextInt(100);
        System.out.println(a);
        return a;
    }

    public static void arrays()
    {
        int[] arr = {5,6,9,8,4,21,54,65,99,32};
        if(arr.length > 0)
        {
            int max = arr[0];
            for (int i = 0; i < arr.length; i++)
            {
                if (arr[i]%2==0) {
                    if (max < arr[i])
                        max = arr[i];
                }
            }
            System.out.println(max);
        }
        else System.out.println("Массив пустой");
    }
}
