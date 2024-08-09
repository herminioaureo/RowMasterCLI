package com.herminio.rowmaster;

import com.google.common.io.Files;

import java.io.File;

/**
 * Class used to validate the arguments passed to the application.
 * @Author: Hermínio Áureo
 */
public class FileValidator {

    /**
     * Method that validates the arguments passed to the application.
     * @param args
     */
    public void validate(String[] args) {
        if (args.length != 2) {
            System.out.println("Invalid arguments!\nUsage: java -jar rowmaster.jar <input_file> <output_directory>");
            System.out.println("Example: java -jar rowmaster.jar C:\\myfolder\\input.txt C:\\myfolder");
            System.exit(1);
        }

        if (args[0] == null || args[0].isEmpty()) {
            System.out.println("Invalid input file name!\nUsage: java -jar rowmaster.jar <input_file> <output_directory>");
            System.out.println("Example: java -jar rowmaster.jar C:\\myfolder\\input.txt C:\\myfolder");
            System.exit(1);
        }

        if(args[1] == null || args[1].isEmpty()) {
            System.out.println("Invalid output directory!\nUsage: java -jar rowmaster.jar <input_file> <output_directory>");
            System.out.println("Example: java -jar rowmaster.jar C:\\myfolder\\input.txt C:\\myfolder");
            System.exit(1);
        }
    }

    /**
     * Method that validates the input file extension.
     * @param fileName
     */
    public void validateFile(String fileName) {
        if (!"txt".equalsIgnoreCase(Files.getFileExtension(fileName))) {
            System.out.println("Invalid input file extension. Only .txt files allowed.");
            System.exit(1);
        }
    }

    /**
     * Method that validates the input file size.
     * @param fileName
     */
    public void validateFileSize(String fileName) {
        File file = new File(fileName);
        if (file.length() > 1000000) {
            System.out.println("File size is too large. Maximum allowed size is 1MB.");
            System.exit(1);
        }
    }
}
