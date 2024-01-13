package homework7afis.b;

public class Main {
    public static void main(String[] args) {
        MultiCopyFile mfc = new MultiCopyFile();
        Sender sender = new Sender(mfc);
        Recipient recipient = new Recipient(mfc);
        Progress progress = new Progress(mfc);

        Thread th1 = new Thread(sender);
        Thread th2 = new Thread(recipient);
        Thread th3 = new Thread(progress);

        th1.start();
        th2.start();
        th3.start();
    }
}

