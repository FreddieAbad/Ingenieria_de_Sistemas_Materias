package cloud.programar.rmidemo.server;

import cloud.programar.rmidemo.Counter;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;

/**
 *
 * @author ciberado
 */
public class AliceMain {


    public static void main(String[] args) throws RemoteException, MalformedURLException, InterruptedException {
        Counter counter = new CounterImpl();
        Naming.rebind("rcounter", counter);
        
        for (int i=0; i < 1000; i++) {
            System.out.println(String.format("Alice loop number: %d. Counter value: %d.", i, counter.getCount()));
            Thread.sleep(1000);
        }
    }
    
}
