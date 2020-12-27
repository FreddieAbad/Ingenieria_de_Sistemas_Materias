
import java.rmi.*;

public class StartFileServer {

    public static void main(String[] args) {
        try {
            java.rmi.registry.LocateRegistry.createRegistry(1099);
            FileServer fs = new FileServer();
            fs.setFile("C:\\archivo.pdf");
            Naming.rebind("rmi://192.168.1.11/abc", fs);
            System.out.println("File Server is Ready");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
