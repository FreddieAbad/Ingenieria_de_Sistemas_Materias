package cloud.programar.rmidemo.client;

import cloud.programar.rmidemo.Counter;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 *
 * @author ciberado
 */
public class BobMain {

    public static void main(String[] args) 
    throws NotBoundException, MalformedURLException, RemoteException, InterruptedException {
        Counter counter = (Counter) Naming.lookup("//localhost/rcounter");
        
        for (int i=0; i < 1000; i++) {
            counter.inc();
            System.out.println(String.format("Bob loop number: %d.", i));
            Thread.sleep(1000);
        }
        
    }
    
}
