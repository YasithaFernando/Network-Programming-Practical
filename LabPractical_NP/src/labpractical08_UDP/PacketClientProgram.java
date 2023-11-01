package labpractical08_UDP;

import java.net.*;
import java.io.*;
import java.util.Scanner;

public class PacketClientProgram {

    private static int INPUT_BUFFER_LIMIT = 500;
    private InetAddress localHost;

    public PacketClientProgram() {
        try {
            localHost = InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
            System.out.println("CLIENT: Error connecting to network");
            System.exit(-1);
        }
    }

    private void sendingMSG(String userName) {
        DatagramSocket socket = null;
        String un = userName;
        String msg = "My index number is "+un;
        //System.out.println(msg);
        
        try {
            socket = new DatagramSocket();
            byte[] sendBuffer = msg.getBytes();
            DatagramPacket sendPacket = new DatagramPacket(
                    sendBuffer,         //store sending data
                    sendBuffer.length,  //lentgh of the data
                    localHost,          //destination IP
                    PacketServer.SERVER_PORT); //destination port
            System.out.println("CLIENT: Sending the request to server");
            socket.send(sendPacket);  //sending the packet
        } catch (IOException e) {
            System.out.println("CLIENT: Error sending the request to server");
        }
        try {
            byte[] receiveBuffer = new byte[INPUT_BUFFER_LIMIT];
            DatagramPacket receivePacket = new DatagramPacket(
                    receiveBuffer,        //recieving buffer
                    receiveBuffer.length);// buffer length
            socket.receive(receivePacket);

            System.out.println("Resopnse : " + new String(
                    receivePacket.getData(),        //retrieves the data from the DatagramPacket 
                    0,                              //specifies the starting index of the byte array
                    receivePacket.getLength()));    //returns the length of the data received
        } catch (IOException e) {
            System.out.println("CLIENT: Cannot receive from server");
        }
        socket.close();
    }

    private static void Delay() {
        try {
            Thread.sleep(400);
        } catch (InterruptedException e) {
        }
    }

    public static void main(String[] args) {
        
        Scanner myObj = new Scanner(System.in);
        String userName;

        System.out.println("Enter username");
        userName = myObj.nextLine();

        PacketClientProgram c = new PacketClientProgram();
        Delay();
        c.sendingMSG(userName);

    }
}
