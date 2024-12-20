package com.work.assignment;

import org.junit.jupiter.api.Test;
import java.io.IOException;

import static org.mockito.Mockito.*;

public class FileReversalProcessorTest {

    @Test
    public void testProcessFile() throws IOException {

        // Create the FileProcessor instance
        FileReversalProcessor fileProcessor = new FileReversalProcessor();
        fileProcessor = spy(fileProcessor);

        // Mock the reading of the file (simulate the input file's contents)
        doReturn("ABC\nDEF\nGHI").when(fileProcessor).readFile("testIn.txt");

        // Mock the writing of the file (verify that the correct content is written)
        doNothing().when(fileProcessor).writeFile("testOut.txt", "IHG\nFED\nCBA");

        // Run the file processing method
        fileProcessor.processFile("testIn.txt", "testOut.txt");

        // Verify that the file reading and writing methods were called with the expected arguments
        verify(fileProcessor).readFile("testIn.txt");
        verify(fileProcessor).writeFile("testOut.txt", "IHG\nFED\nCBA");
    }
}
