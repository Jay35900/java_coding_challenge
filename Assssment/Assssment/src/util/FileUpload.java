package util;


import exception.FileUploadException;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class FileUpload {

    private static final long MAX_FILE_SIZE = 1024 * 1024 * 5; // 5 MB limit

    public static void uploadResume(File file) throws FileUploadException {
        if (!file.exists()) {
            throw new FileUploadException("File not found: " + file.getName());
        }
    }

    public static void main(String[] args) {
        File file = new File("resume.txt"); // Example invalid file format

        try {
            uploadResume(file);
        } catch (FileUploadException e) {
            System.out.println(e.getMessage());
        }
    }
}



