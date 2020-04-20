public class Main
{
    public static void main(String[] args)
    {
        cycleWhile(77);
        doWhile(10);
    }
    public static void cycleWhile(int maxLength)
    {
        String string = "Helloworld";
//проверяем количество заданных символов, еслизначение истинно добавлем ещё строку
        String result ="";

        while(result.length()+string.length() <= maxLength)
        {
            result+="HelloWorld";
        }

        System.out.print(result);
    }

    public static void doWhile(int c)
    {
        //сначала делаем do единажды потом проверяются условия
        do
        {
            System.out.println("осталось " + c + " секунд \n");
// Если есловия правильные цикл повторяется еще раз пока не станут false
        } while (--c > -1);
    }
}
