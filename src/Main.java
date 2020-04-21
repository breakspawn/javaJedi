import java.io.*;
import java.util.Scanner;

public class Main
{

    public static void main(String[] args)
    {

    }
}

class Parser {

    private File file;
    public Parser(File f){
        file = f;
    }

    public String read(boolean outToConsole) throws IOException {
        InputStream in = new FileInputStream(file);
        String output = "";
        int bt = 0;
        do{
            bt = in.read();
            if(bt > 0)
                output += (char) bt;
        }while(bt > 0);

        if(outToConsole)
        {
            System.out.print(output);
            return "";
        }
        else
        {
            return output;
        }
    }

    public void write(String content, boolean fromConsole) throws IOException
    {
        if(fromConsole)
        {
            Scanner scan = new Scanner(System.in);
            content = scan.nextLine();
        }

        OutputStream os = new FileOutputStream(file);

        for(int i = 0; i < content.length(); i++)
        {
            os.write(content.charAt(i));
        }
    }
}
