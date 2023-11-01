
package labpractical10_RMI;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class MyRemoteObject extends UnicastRemoteObject implements MyRemoteInterface {
    public MyRemoteObject() throws RemoteException {

    }
    // Constructor must throw RemoteException
    public String sayHello() throws RemoteException { 
        return "Hello from the remote object!";
    }

}

