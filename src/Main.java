import java.util.Scanner;

public class Main
{

    public static void main(String[] args)
    {
        ReaderConsole reader = new ReaderConsole();
        try
        {
            int x = reader.getInt();
            System.out.println(x);
        } catch (NumberFormatException nfe) {
            System.out.println("неправильное значение");
        }
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