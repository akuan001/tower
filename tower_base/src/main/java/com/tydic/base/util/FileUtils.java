package com.tydic.base.util;

import java.io.File;
import java.io.IOException;

public class FileUtils {
    public static boolean deleteFile(String dir) throws IOException {
        File dirFile = new File(dir);
        if (!dirFile.exists()) {
            return false;
        }
        if (dirFile.isDirectory()) {
            File[] files = dirFile.listFiles();
            for (File file : files) {
                if (file.isDirectory()) {
                    deleteFile(file.getAbsolutePath());
                } else {
                    file.delete();
                }
            }
            dirFile.delete();
        } else {
            dirFile.delete();
        }

        return true;
    }
}
