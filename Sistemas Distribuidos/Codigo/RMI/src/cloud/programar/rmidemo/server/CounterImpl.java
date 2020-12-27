package cloud.programar.rmidemo.server;

import cloud.programar.rmidemo.Counter;
import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author ciberado
 */
public class CounterImpl extends UnicastRemoteObject implements Counter, Serializable {
    
    private static final long serialVersionUID  = 1L;
    
    private int count;

    public CounterImpl() throws RemoteException {
        count = 0;
    }
    
    @Override
    public int inc() {
        count++;
        return count;
    }
    
    @Override
    public int dec() {
        count--;
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getCount() {
        return count;
    }
    
    
    
}
