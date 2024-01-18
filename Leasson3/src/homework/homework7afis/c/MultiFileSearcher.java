package homework7afis.c;

import java.io.File;

public class MultiFileSearcher implements Runnable {
    private File[] folders;
    private File folderWherNeedToFindFile;
    private String fileNeedToFind;
    private boolean tf = false;

    public MultiFileSearcher(String fileName, File folderName) {
        setFileNeedToFind(fileName);
        setFolderWherNeedToFindFile(folderName);
        setFolders(folderWherNeedToFindFile.listFiles());
    }

    public MultiFileSearcher() {
    }

    public boolean searshFileByName(File folderName, String fileName) {
        if (folders == null) {
            return false;
        }
        for (int i = 0; i < folders.length; i++) {
            if (folders[i].isFile() && folders[i].getName().equals(fileName)) {
                tf = true;
                return tf;
            }
            if (folders[i].isDirectory()) {
                setFolderWherNeedToFindFile(new File(folders[i].getAbsolutePath()));
                Thread th = new Thread(new MultiFileSearcher(fileName, getFolderWherNeedToFindFile()));
                th.start();
            }
        }
        return tf;
    }

    @Override
    public void run() {
        if (searshFileByName(folderWherNeedToFindFile, fileNeedToFind) == true) {
            System.out.println(Thread.currentThread().getName() + " found file: " + folderWherNeedToFindFile + "/" + fileNeedToFind);
        } else
            System.out.println(Thread.currentThread().getName() + " don't found file");
    }

    public File getFolderWherNeedToFindFile() {
        return folderWherNeedToFindFile;
    }

    public void setFolderWherNeedToFindFile(File folderWherNeedToFindFile) {
        this.folderWherNeedToFindFile = folderWherNeedToFindFile;
    }

    public String getFileNeedToFind() {
        return fileNeedToFind;
    }

    public void setFileNeedToFind(String fileNeedToFind) {
        this.fileNeedToFind = fileNeedToFind;
    }

    public File[] getFolders() {
        return folders;
    }

    public void setFolders(File[] folders) {
        this.folders = folders;
    }


}
