import java.io.*;
import java.util.Scanner;

public class Main
{

    public static void main(String[] args)
    {
        try {
            Parser parser = new Parser(new File("C:\\","ParserShitCode.txt"));
            parser.fromConsole();
            parser.toConsole();
        } catch (IOException ioException) {}
    }
}

class Parser {

    private File file;
    public Parser(File f){
        file = f;
    }
    // метод возвравата данных в строку
    public String read() throws IOException {
        InputStream in = new FileInputStream(file);
        String output = "";
        int bt = in.read();
        while (bt > 0) {
            output += (char) bt;
            bt = in.read();
        }
        return output;
    }

    public void toConsole() throws IOException {
        System.out.println(read());
    }


    // была функция которая записывала в файл содержимое из консоли или то что мы передали
    // 1. Запись в файл из консоли
    // 2. Запись в файл переданного содержимого
    // разбить:

    // 1.
    public void fromConsole() throws IOException {
        Scanner scan = new Scanner(System.in);
        String content = scan.nextLine();
        write(content);
    }

    // 2.
    public void write(String content) throws IOException {
        OutputStream os = new FileOutputStream(file);
        for(int i = 0; i < content.length(); i++)
        {
            os.write(content.charAt(i));
        }
    }





}
