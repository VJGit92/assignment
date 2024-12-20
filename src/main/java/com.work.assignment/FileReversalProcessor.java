package com.work.assignment;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;

public class FileReversalProcessor {

    private String reverse(String input) {
        if (input == null) {
            return null;
        }
        return new StringBuilder(input).reverse().toString();
    }

    public void processFile(String inputFilePath, String outputFilePath) throws IOException {
        // Read the entire file content (handles multiline files)
        String inputContent = readFile(inputFilePath);

        // Reverse the content (including all lines and the characters in the lines)
        String reversedContent = reverse(inputContent);

        // Write the reversed content to the output file
        writeFile(outputFilePath, reversedContent);
    }

    // Method to read the entire file as a single string (including multiline content)
    public String readFile(String filePath) throws IOException {
        return Files.lines(Paths.get(filePath))
                .collect(Collectors.joining(System.lineSeparator()));
    }

    // Method to write content to a file
    public void writeFile(String filePath, String content) throws IOException {
        Files.write(Paths.get(filePath), content.getBytes());
    }
}
