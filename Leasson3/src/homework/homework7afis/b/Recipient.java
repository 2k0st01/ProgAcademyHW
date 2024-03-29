package homework7afis.b;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Recipient {
    private MultiCopyFile mcf;
    private File fileOut = new File("DWSample3-TXTCopy.txt");

    public Recipient(MultiCopyFile mcf) {
        this.mcf = mcf;
    }

    public void push() {
        try (FileOutputStream fos = new FileOutputStream(fileOut)) {
            for (; !mcf.isStop(); ) {
                fos.write(mcf.getBytesArray());
            }
            fos.write(mcf.getEndBytesArray() );
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
