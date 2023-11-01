package labpractical06;

import java.io.BufferedReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Server {

    public static void main(String[] args) {

        final int port = 8080; // server port

        ServerSocket serversocket; // instance of ServerSocket class

        try {
            serversocket = new ServerSocket(port); // 
            System.out.println(serversocket); // displays address and the port as the content of the ServerSocket instance

            while (true) {
                Socket clientsocket = serversocket.accept();

                InputStream in = clientsocket.getInputStream();

                InputStreamReader reader = new InputStreamReader(in);
                BufferedReader Bfreader = new BufferedReader(reader);
                String response = Bfreader.readLine();
                System.out.println(response);

                ClientHandler clienthandler = new ClientHandler(clientsocket);
                Thread clientthread = new Thread(clienthandler);
                clientthread.start();
            }

        } catch (IOException e) {
            System.out.println(" Cannot open a connection ");
        }

    }

}
