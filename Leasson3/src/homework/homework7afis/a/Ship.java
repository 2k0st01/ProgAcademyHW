package homework7afis.a;

public class Ship implements Runnable{
    private int boxes = 10;
    private int shipNumber;

    public Ship(){

    }
    public Ship(int shipNumber){
        this.shipNumber = shipNumber;
    }

    public int getBoxes() {
        return boxes;
    }

    @Override
    public void run() {
        for (int i = 10; i != 0 ; i--) {

            try {
                System.out.println("Ship: " + shipNumber + ": "+ boxes + "boxes left");
                Thread.sleep(500);
                boxes -= 1;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Ship " + shipNumber + ": have completed unloading");
    }
}

