package homework7afis.b;

public class Progress{
    private MultiCopyFile mcf;

    public Progress(MultiCopyFile mcf){
        this.mcf = mcf;
    }

    public void push() {
        while (!mcf.isStop()){
            long percent = mcf.getPercent();
            if(percent < 100){
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(percent + " % done");
            }
        }
        System.out.println("Completed 100%");
    }
}
