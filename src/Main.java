import java.util.Random;
import java.util.Scanner;


public class Main
{
    public static void main(String[] args)
    {
        ReaderConsole reader = new ReaderConsole();
        try
        {
            int x = reader.getInt();
            int y = reader.getInt();
            MatrixArray matrixArray = new MatrixArray(x,y);
            matrixArray.randomFill(50);

            System.out.println("Минимальное значение: "+ matrixArray.minElement() + "\nМаксимальное значение: " + matrixArray.maxElement() + "\n" + matrixArray.allElements());

        } catch (NumberFormatException nfe) {
            System.out.println("неправильное значение");
        }
    }
}

class MatrixArray
{
    int[][] matrix;
    final int x;
    final int y;

    public MatrixArray(int width, int height)
    {
        x = width;
        y = height;
        matrix = new int[x][y];
    }
    public int length()
    {
        return x*y;
    }

    public void randomFill(int maxRange)
    {
        Random random = new Random();
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++)
                matrix[i][j] = random.nextInt(maxRange);
        }
    }
     public int maxElement()
     {
         int resultMax = 0;
         if (length() > 0)
         {
             resultMax = matrix[0][0];
             for (int i = 0; i < x; i++) {
                 for (int j = 0; j < y; j++) {
                     if (resultMax < matrix[i][j])
                     {
                         resultMax = matrix[i][j];
                     }

                 }

             }
         }
         return resultMax;
     }

     public int minElement(){
         int resultMin = 0;
         if (length() > 0)
         {
             resultMin = matrix[0][0];
             for (int i = 0; i < x; i++) {
                 for (int j = 0; j < y; j++) {
                     if (resultMin > matrix[i][j])
                     {
                         resultMin = matrix[i][j];
                     }
                 }
             }
         }
         return resultMin;
     }

     /*
     0 0 0
     0 0 0
     0 0 0
      */
     public String allElements()
     {
        String result = "";
         for (int i = 0; i < y; i++) {
             for (int j = 0; j < x; j++) {
                 result += " " + matrix[j][i];
             }
             result += "\n";

         }
        return result;
     }
}

class ReaderConsole
{
    Scanner scanner;

    public ReaderConsole()
    {
        scanner = new Scanner(System.in);
    }
    
    public int getInt() throws NumberFormatException
    {
        String s = scanner.next();
        int number = Integer.valueOf(s);
        return number;
    }
}
