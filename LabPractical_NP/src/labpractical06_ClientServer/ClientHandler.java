package labpractical06;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientHandler implements Runnable {

    Socket clientsocket;

    public ClientHandler(Socket clientsocket) {
        this.clientsocket = clientsocket;
    }

    @Override
    public void run() {

        OutputStream outs = null;
        try {
            outs = clientsocket.getOutputStream();
            PrintWriter write = new PrintWriter(outs, true);
            write.println("Hello Client! This is the Server...");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                outs.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
