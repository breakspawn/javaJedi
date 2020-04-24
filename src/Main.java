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
        rf.writeTextToFile(res, "bbc");

        System.out.println(res);


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
    public void writeTextToFile (String text, String fileName) throws IOException {
        File file = new File("c:\\", fileName);
        OutputStream os = new FileOutputStream(file);
        for (int i = 0; i < text.length(); i++) {
            os.write(text.charAt(i));
        }
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





