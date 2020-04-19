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
        //сначала делаем do единажды потом проверяются условия
        do
        {
            System.out.println("осталось " + c + " секунд \n");
// Если есловия правильные цикл повторяется еще раз пока не станут false
        } while (--c > -1);
    }
}
