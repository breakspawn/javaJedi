public class Main
{
    public static void main(String[] args)
    {
        String string = "";

        while(string.length() < 36)
        {
            string+="Hello World \n";
        }

        System.out.println(string);
        doWhile();
    }

    public static void doWhile()
    {
        int c = 10;
        do
        {
            System.out.println("осталось " + c + " секунд \n");
            c--;
        } while (c > 0);
    }
}
