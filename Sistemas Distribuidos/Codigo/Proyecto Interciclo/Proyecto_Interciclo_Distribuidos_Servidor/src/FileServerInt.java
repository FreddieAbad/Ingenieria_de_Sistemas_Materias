
import java.rmi.*;

public interface FileServerInt extends Remote{
    public boolean login(FileClientInt c) throws RemoteException;
}
