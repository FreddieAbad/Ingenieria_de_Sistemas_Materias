package cloud.programar.rmidemo;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author ciberado
 */
public interface Counter extends Remote {

    int dec() throws RemoteException;

    int inc() throws RemoteException;
    
    int getCount() throws RemoteException;;
}
