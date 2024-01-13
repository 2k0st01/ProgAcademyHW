package homework7afis.b;

import java.io.File;

class MultiCopyFile{
    private byte[] bytesArray;
    boolean turn = false;
    boolean stop;
    private File fileIn = new File ("DWSample3-TXT.txt");
    private long possibleForUse = fileIn.length();
    private long percent;

    public MultiCopyFile() {

    }

    public File getFileIn(){
        return fileIn;
    }

    public void setFileIn(File fileIn){
        this.fileIn = fileIn;
    }

    public long getPossibleForUse() {
        return possibleForUse;
    }

    public void setPossibleForUse(long possibleForUse) {
        this.possibleForUse = possibleForUse;
    }

    public long getPercent(){
        this.percent = (fileIn.length() - getPossibleForUse()) / (fileIn.length() / 100);
        return percent;
    }

    public synchronized byte[] getBytesArray() {
        while (turn = false){
            try{
                wait();
            } catch (InterruptedException e){
                System.out.println(e);
            }
        }
        turn = false;
        notifyAll();
        return bytesArray;
    }

    public synchronized void setBytesArray(byte[] arr) {
        for (; turn == true; ) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
        this.bytesArray = arr;
        turn = true;
        notifyAll();
    }

    public boolean isStop() {
        return stop;
    }

    public void setStop(boolean stop) {
        this.stop = stop;
    }

    public byte[] getEndBytesArray() {
        return bytesArray;
    }
}
