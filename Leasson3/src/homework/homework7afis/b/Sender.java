package homework7afis.b;

import java.io.FileInputStream;
import java.io.IOException;

public class Sender implements Runnable{
    private MultiCopyFile mtf;

    public Sender(MultiCopyFile mtf){
        this.mtf = mtf;
    }

    private void readByte(FileInputStream fis, byte[] buffer) throws IOException {
        fis.read(buffer);
        mtf.setBytesArray(buffer);
        mtf.setSizeInBytes(mtf.getPossibleForUse() - buffer.length);
    }

    @Override
    public void run() {
        byte[] buffer = new byte[1024];
        try (FileInputStream fis = new FileInputStream(mtf.getFileIn())) {
            readByte(fis, buffer);
            for (; mtf.getPossibleForUse() > 0; ) {
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                buffer = new byte[1024];
                readByte(fis, buffer);
            }
            mtf.setStop(true);
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
