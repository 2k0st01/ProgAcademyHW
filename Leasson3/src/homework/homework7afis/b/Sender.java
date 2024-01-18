package homework7afis.b;

import java.io.FileInputStream;
import java.io.IOException;

public class Sender {
    private MultiCopyFile mtf;

    public Sender(MultiCopyFile mtf){
        this.mtf = mtf;
    }

    private void readByte(FileInputStream fis, byte[] buffer) throws IOException {
        fis.read(buffer);
        mtf.setBytesArray(buffer);
        mtf.setSizeInBytes(mtf.getSizeInBytes() - buffer.length);
    }

    public void push() {
        byte[] buffer = new byte[1024];
        try (FileInputStream fis = new FileInputStream(mtf.getFileIn())) {
            readByte(fis, buffer);
            while (mtf.getSizeInBytes() > 0) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if(buffer.length > mtf.getSizeInBytes()){
                    buffer = new byte [(int) mtf.getSizeInBytes()];
                } else buffer = new byte[1024];
                readByte(fis, buffer);
            }
            mtf.setStop(true);
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}