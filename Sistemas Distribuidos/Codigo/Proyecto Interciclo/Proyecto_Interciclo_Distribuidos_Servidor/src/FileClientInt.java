
import java.rmi.*;

public interface FileClientInt extends Remote {

    public boolean sendData(String filename, byte[] data, int len) throws RemoteException;
    public String getName() throws RemoteException;
}
