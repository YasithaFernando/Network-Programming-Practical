package labpractical10_RMI;

import java.rmi.Naming;

public class RMIClient {

    public static void main(String[] args) {

        try {
            MyRemoteInterface remoteObject = (MyRemoteInterface)Naming.lookup("rmi://localhost/MyRemoteObject");
            String message = remoteObject.sayHello();
            System.out.println("Message from server" + message);

        } 
        catch (Exception e) {
            e.printStackTrace();
    
        }

    }

}



