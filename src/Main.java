import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.Buffer;

public class Main
{
    public static void main(String[] args) throws IOException {
        server();
       // client();
   }
    public static void server() throws IOException {
        try (ServerSocket server = new ServerSocket(3345))
        {
            Socket client = server.accept();
            System.out.println("Connection accepted...");
            DataOutputStream out = new DataOutputStream(client.getOutputStream());
            System.out.println("DataOutputStream created...");
            DataInputStream in = new DataInputStream(client.getInputStream());
            System.out.println("DataInputStream created...");
            while (!client.isClosed())
            {
                System.out.println("Server is reading from channel");
                String entry = in.readUTF();
                System.out.println("Read from client message: " +entry);
                System.out.println("Server try writing to channel");
                if (entry.equalsIgnoreCase("quit"))
                {
                    System.out.println("Client initialize connection suicide ...");
                    out.writeUTF("Server reply " + entry + " - OK");
                    out.flush();
                    break;
                }
                out.writeUTF("Server reply - " + entry + " - OK");
                System.out.println("Server wrote message to client");
                out.flush();
            }
            System.out.println("Client disconnected");
            System.out.println("Closing channels & channels.");
            in.close();
            out.close();
            client.close();
            System.out.println("Closing channels & channels - DONE");
        } catch (IOException e)
        {
            e.printStackTrace();
            System.out.println("Ошибка подключения");
            server();
        }
    }
    public static void client()
    {
        try (Socket socket = new Socket("localhost", 3345);
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            DataOutputStream oos = new DataOutputStream(socket.getOutputStream());
            DataInputStream ois = new DataInputStream(socket.getInputStream());)
        {
            System.out.println("Client connect to socket.");
            System.out.println();
            System.out.println("Client writing channel = oss & reading channel = ois initialized. ");

            while (!socket.isOutputShutdown())
            {
                if (br.ready())
                {
                    System.out.println("Client start writing in channel...");
                    String clientCommand = br.readLine();

                    oos.writeUTF(clientCommand);
                    oos.flush();
                    System.out.println("Client send message: " + clientCommand + " to server");
                    Thread.sleep(1000);
                    if (clientCommand.equalsIgnoreCase("quit"))
                    {
                        System.out.println("Client kill connection");
                        Thread.sleep(2000);
                        if (ois.read() > -1)
                        {
                            System.out.println("reading...");
                            String in = ois.readUTF();
                            System.out.println(in);

                        }
                        break;
                        }
                    }
                }
            System.out.println("Closing connection & channels on clientSide - DONE.");
            } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


