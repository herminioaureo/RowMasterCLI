package com.herminio.rowmaster;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Class used to read the input file and create the output file.
 * @Author: Hermínio Áureo
 */
public class FileUtil {

    /**
     * Method that reads the input file and returns the content as a single line.
     * @param inputFileName
     * @return String
     */
    public String read(String inputFileName) {
        try {
            FileValidator validator = new FileValidator();
            validator.validateFile(inputFileName);
            validator.validateFileSize(inputFileName);

            BufferedReader reader = new BufferedReader(new FileReader(inputFileName));
            String line;
            List<String> lines = new ArrayList<String>();
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
            reader.close();
            System.out.println("Total lines in file: " + lines.size());
            String newLine = "";
            StringBuilder sb = new StringBuilder();
            for(String l : lines) {
                sb.append(l.strip().replaceAll("\\s{2,}", " ").replaceAll("\\r", " ")
                        .replaceAll("\\n", " ").replaceAll("\\t", " ")).append(" ");
            }
            newLine = sb.toString();
            return newLine;

        } catch (IOException e) {
            System.out.println("An IOException error occurred." + e.getMessage());
            System.exit(1);
        } catch (Exception e) {
            System.out.println("An error occurred." + e.getMessage());
            System.exit(1);
        }
        return null;
    }

    /**
     * Method that writes the output file.
     * @param outputFileName
     * @param content
     */
    public void write(String outputFileName, String content) {
        try {
            File outputFile = new File(outputFileName);
            if (outputFile.createNewFile()) {
                System.out.println("File created: " + outputFile.getName());
            } else {
                System.out.println("File already exists.");
            }

            FileWriter fileWriter = new FileWriter(outputFileName);
            fileWriter.write(content);
            fileWriter.close();
            System.out.println("Successfully wrote to the file.");

        } catch (IOException e) {
            System.out.println("An IOException error occurred." + e.getMessage());
            System.exit(1);
        } catch (Exception e) {
            System.out.println("An error occurred." + e.getMessage());
            System.exit(1);
        }
    }
}
