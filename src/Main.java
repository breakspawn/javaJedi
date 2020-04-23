import java.io.*;

public class Main
{


    File f;
    String result;

    public static void main(String[] args) throws IOException
    {
        //Копирование файлов
      CopyFiles copyFiles = new CopyFiles();
      File from = new File("c:\\", "Shitcode");
      File to =  new File("c:\\", "Shitcode0000");
      copyFiles.CopyFiles(from, to);

//замена текста файла на заглавные буквы
        FileToText rf = new FileToText();
        String c = rf.readFile("c:\\Shitcode");
        String res = c.toUpperCase();
        File f = new File("c:\\", "abc");
        System.out.println(res);
        OutputStream os = new FileOutputStream(f);
        for (int i = 0; i < res.length(); i++) {
            os.write(res.charAt(i));

        }

    }
}
//считываю символы из файла и возвращаю строку
class FileToText {
    public String readFile(String fN) throws FileNotFoundException {
        String str = "";

        try (FileReader fr = new FileReader(fN)) {
            int c;
            while ((c = fr.read()) != -1) {
                str += (char)c;

            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

        return str;
    }
    public void writeTextToFile (String fileName) throws IOException {
        FileWriter fileWriter = new FileWriter(fileName);

    }
 }


class CopyFiles
{
    //метод потокового копирования файлов
    public void CopyFiles (File source,File dest) throws IOException
    {
        InputStream is = null;
        OutputStream os = null;
        try
        {
            is = new FileInputStream(source);
            os = new FileOutputStream(dest);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = is.read(buffer)) > 0)
            {
                os.write(buffer, 0, length);
            }
        } finally
        {
            is.close();
            os.close();
        }
    }
}





