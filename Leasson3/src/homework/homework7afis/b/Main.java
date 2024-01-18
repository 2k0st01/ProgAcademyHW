package homework7afis.b;

public class Main {
    public static void main(String[] args) {
        MultiCopyFile mfc = new MultiCopyFile();
        Sender sender = new Sender(mfc);
        Recipient recipient = new Recipient(mfc);
        Progress progress = new Progress(mfc);

        Thread th1 = new Thread(new Runnable() {
            @Override
            public void run() {
                recipient.push();
            }
        });

        Thread th2 = new Thread(new Runnable() {
            @Override
            public void run() {
                sender.push();
            }
        });

        Thread th3 = new Thread(new Runnable() {
            @Override
            public void run() {
                progress.push();
            }
        });

        th1.start();
        th2.start();
        th3.start();

    }
}