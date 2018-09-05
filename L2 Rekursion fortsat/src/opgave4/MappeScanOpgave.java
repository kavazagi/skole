package opgave4;

import java.io.File;

public class MappeScanOpgave {
    public static int scanDirCount(String path) {
        int count = 0;
        File file = new File(path);
        String[] names = file.list();
        for (String name : names) {
            String newPath = path + "/" + name;
            if ((new File(newPath)).isDirectory()) {
                scanDirCount(newPath);
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(scanDirCount("C:\\Users\\User\\Desktop\\Datamatiker bøger"));
    }
}
