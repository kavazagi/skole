package opgave4;

import java.io.File;

public class MappeScanTEST {
    public static void scanDir(String path) {
        System.out.println("[DIR] " + path);
        File file = new File(path);
        String[] names = file.list();
        for (String name : names) {
            String newPath = path + "/" + name;
            if ((new File(newPath)).isDirectory()) {
                scanDir(newPath);
            }
        }
    }

    public static void main(String[] args) {
        scanDir("C:\\Users\\User\\Desktop");
    }

}
