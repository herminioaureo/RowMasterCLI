package com.herminio.rowmaster;

import java.text.SimpleDateFormat;

public class Rowmaster {

    public static void main(String[] args) {
        System.out.println("... Welcome to Rowmaster ...");
        System.out.println("This software is provided AS IS, without any warranty. Use at your own risk.");
        System.out.println("    ____                __  ___           __           \n" +
                "   / __ \\____ _      __/  |/  /___ ______/ /____  _____\n" +
                "  / /_/ / __ \\ | /| / / /|_/ / __ `/ ___/ __/ _ \\/ ___/\n" +
                " / _, _/ /_/ / |/ |/ / /  / / /_/ (__  ) /_/  __/ /    \n" +
                "/_/ |_|\\____/|__/|__/_/  /_/\\__,_/____/\\__/\\___/_/     \n" +
                "                                                    ");
        System.out.println("Software under GPL 3.0 Licence. See: https://www.gnu.org/licenses/gpl-3.0.html");
        System.out.println("Author: Hermínio Áureo\n");

        if (args.length != 2) {
            System.out.println("Invalid arguments!\nUsage: java -jar rowmaster.jar <input_file> <output_directory>");
            System.out.println("Example: java -jar rowmaster.jar C:\\myfolder\\input.txt C:\\myfolder");
            System.exit(1);
        }

        String inputFileName = args[0].replaceAll("//", "\\\\");
        String outputFileName = args[1].replaceAll("//", "\\\\");

        System.out.println("Input file: " + inputFileName);
        System.out.println("Output Dir: " + outputFileName);

        FileUtil fileUtil = new FileUtil();
        String fileContent = fileUtil.read(inputFileName);

        SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyyy-kkmmss");
        outputFileName = outputFileName.concat("\\output_file").concat(formatter.format(System.currentTimeMillis())).concat(".txt");

        fileUtil.write(outputFileName, fileContent);
        System.exit(0);
    }
}
