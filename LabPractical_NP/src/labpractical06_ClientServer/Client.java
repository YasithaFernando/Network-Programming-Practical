
package labpractical06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;


public class Client {
    
    public static void main(String[] args) {
        
        final String address = "localhost";
        final int port = 8080;
        try {
            
            Socket clientsocket = new Socket(address, port);
            
            OutputStream outs = null;

            outs = clientsocket.getOutputStream();
            PrintWriter write = new PrintWriter(outs,true);
            write.println("Hello Server! This is the Client...");
   
            InputStream in = clientsocket.getInputStream();

            InputStreamReader reader = new InputStreamReader(in);
            BufferedReader Bfreader = new BufferedReader(reader);
            String response = Bfreader.readLine();
            
            System.out.println(response);
    
        } catch (IOException e) {
            System.out.println(e);
        }        
    }
}
