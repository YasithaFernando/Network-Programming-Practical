package labpractical10_RMI;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class MyRMIServer {

    public static void main(String[] args) {
        try {
            MyRemoteInterface remoteObject = new MyRemoteObject();
            LocateRegistry.createRegistry(1099); // Create a registry on port 1099
            Naming.rebind("MyRemoteObject", remoteObject); // Bind the object to the registry System.out.println("Server is running...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

