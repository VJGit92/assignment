package com.work.assignment;

import java.io.*;

public class App {

    public static void main(String[] args) {

        String inputFile = "src/main/resources/input.txt";
        String outputFile = "src/main/resources/output.txt";
        FileReversalProcessor processor = new FileReversalProcessor();

        try {
            processor.processFile(inputFile, outputFile);
        } catch (IOException e) {
            System.err.println("Error processing files: " + e.getMessage());
        }
    }
}
