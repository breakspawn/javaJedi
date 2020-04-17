import java.lang.reflect.Array;
import java.util.Arrays;

public class Main
{


    public static void main(String[] args)
    {
        int[] arr = {5,6,9,8,4,21,54,65,99,32};
        if(arr.length > 0)
        {
            int max = arr[0];
            for (int i = 0; i < arr.length; i++)
            {
                if (max > arr[i]) {
                    max = arr[i];
                }
            }
            System.out.println(max);
        }
    }
}
