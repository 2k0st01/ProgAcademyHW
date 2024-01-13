package homework7afis.a;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(2);
        for(int i = 1; i<4; i++){
            Runnable port = new Ship(i);
            service.execute(port);
        }
        service.shutdown();
    }
}
