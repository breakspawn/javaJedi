import javax.sound.midi.Soundbank;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.concurrent.Exchanger;

public class myGui{
    private JButton button1;
    private JPanel panel1;
    private JTextField textField1;
    private JTextPane textPane1;
    private JButton Connect;
    boolean on;
    String cc;
    String t= "";

    Socket socket;
    DataOutputStream oos;

    public void sendMessage(String msg) {cc = msg;}


    boolean isListen = false;
    public myGui() throws IOException {
        JFrame frame = new JFrame();
        frame.setContentPane(panel1);
        frame.setVisible(true);
        frame.setSize(500, 500);
        String[] tmp = {""};


        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String s = textField1.getText();
                tmp[0] += "\n" + s;
                System.out.println("message send......");
                on = true;
                sendMessage(s);
                String clientCommand = textField1.getText();
                try {
                    oos.writeUTF(clientCommand);
                    oos.flush();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });
        Connect.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Connect.setSelected(!Connect.isSelected());
                    if(Connect.isSelected()) {
                        socket = new Socket("localhost", 3345);
                        oos = new DataOutputStream(socket.getOutputStream());
                        System.out.println("Connection enable...");
                        new Thread(new Runnable() {
                            @Override
                            public void run() {
                                listenAndServ(socket);
                            }
                        }).start();
                    } else {
                        socket.close();
                        oos.close();
                    }
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });
    }
    public void listenAndServ(Socket socket)
    {
                try (DataInputStream ois = new DataInputStream(socket.getInputStream());) {
                    System.out.println("Client connect to socket.");
                    System.out.println();
                    System.out.println("Client writing channel = oss & reading channel = ois initialized. ");


                    while (!socket.isOutputShutdown()) {
                        System.out.println("Client start writing in channel...");
                        System.out.println("Client send message: " + cc + " to server");
                        Thread.sleep(1000);
                        t += ois.readUTF() + "\n";
                        textPane1.setText(t);
                        if (cc.equalsIgnoreCase("quit")) {
                            System.out.println("Client kill connection");
                            Thread.sleep(2000);
                            if (ois.read() > -1) {
                                System.out.println("reading...");
                                String in = ois.readUTF();
                                System.out.println(in);
                            }
                            break;
                        }
                        if (!Connect.isSelected())
                            break;
                        System.out.println("Closing connection & channels on clientSide - DONE.");
                    }


                } catch (InterruptedException | IOException e) {
                    e.printStackTrace();
                }
            }
        }


