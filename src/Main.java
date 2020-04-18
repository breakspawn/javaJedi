import java.util.Random;


public class Main
{
    public static void main(String[] args)
    {
           arrays();
           matrix();

    }

    public static void matrix(){

        final int SIZE = 3;

        //создание матрицы
        int[][] matrix = new int[SIZE][SIZE];
        //заполнение матрицы рандомными числами
        for (int i = 0; i < SIZE; i++)
        {
            for (int j = 0; j < SIZE; j++)
                matrix[i][j] = randomInt();
        }

        //-------------------------------------------
        //поис
        if(matrix.length > 0) {
            int max = matrix[0][0];
            int x = 0, y = 0;
            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++) {
                    if (max < matrix[i][j]) {
                        max = matrix[i][j];
                        // запомнить позицию максимального эллемента, что бы вывести ее после
                        x = i;
                        y = j;
                    }
                }
            }
            // N[x],[]
            System.out.println(max + " [" + x + "][" + y + "]");
        }
        else {
            System.out.println("Матрица не задана");
        }

    }

//генератор рандомных числов
    public static int randomInt()
    {
        Random random = new Random();
        //bound диапазон переменных 0 до ... если не указывать диапазон то будет по от -max int до +max int
        int a = random.nextInt(100);
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
                // если число делится на 2 без остатка - оно четное
                if (arr[i]%2==0) {
                    // если последнее максимальное меньше чем текущее четное число - запомнить текущий
                    if (max < arr[i])
                        max = arr[i];
                }
            }
            System.out.println(max);
        }
        else System.out.println("Массив пустой");
    }
}
