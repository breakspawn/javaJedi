public class Main
{
    public static void main(String[] args)
    {

        cycleWhile(76);
        doWhile(10);
    }
    public static void cycleWhile(int maxLength)
    {
        String string = "";

//проверяем количество заданных символов, еслизначение истинно добавлем ещё строку
        while(string.length() < maxLength)
        {
            string+="Hello World \n";
        }

        System.out.println(string);
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
