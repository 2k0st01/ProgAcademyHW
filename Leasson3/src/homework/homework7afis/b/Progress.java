package homework7afis.b;

public class Progress implements Runnable{
    private MultiCopyFile mcf;

    public Progress(MultiCopyFile mcf){
        this.mcf = mcf;
    }

    @Override
    public void run() {
        while (!mcf.isStop()){
            long percent = mcf.getPercent();
            if(percent < 100){
                System.out.println(percent + " % done");
            }
        }
        System.out.println("Completed");
    }
}
