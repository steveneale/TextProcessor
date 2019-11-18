/**
 * 'FileReader.java'
 *
 * Read file content.
 *
 * 2019 Steve Neale <steveneale3000@gmail.com>
 */

package com.steveneale.textprocessor.io;

import com.steveneale.textprocessor.exceptions.FileReadingException;

import java.io.*;


public class FileReader {

    /**
     * Get the contents of a file as a String
     *
     * @param filePath Path to a file whose contents should be returned
     * @return         Contents of the file as a String
     * @throws FileReadingException Unsupported encoding provided to the InputStreamReader
     * @throws FileReadingException The BufferedReader was unable to read a line
     */
    public String fileContentsAsString(String filePath) throws FileReadingException {
        BufferedInputStream bufferedStream = bufferedInputStreamFromFile(filePath);
        return stringFromBufferedInputStream(bufferedStream);
    }

    /**
     * Get a BufferedInputStream for a given file
     *
     * @param filePath Path to a file for which a BufferedInputStream should be returned
     * @return         BufferedInputStream object for the given file
     * @throws FileReadingException Unsupported encoding provided to the InputStreamReader
     * @throws FileReadingException The BufferedReader was unable to read a line
     */
    private BufferedInputStream bufferedInputStreamFromFile(String filePath) throws FileReadingException {
        try {
            InputStream fileInputStream = new FileInputStream(filePath);
            return new BufferedInputStream(fileInputStream);
        } catch (FileNotFoundException e) {
            throw new FileReadingException("The given file '" + filePath + "' could not be found: " + e.getMessage());
        }
    }

    /**
     * Get a String from a BufferedInputStream
     *
     * @param stream                A BufferedInputStream object
     * @return                      A String object containing the BufferedInputStream's file contents
     * @throws FileReadingException Unsupported encoding provided to the InputStreamReader
     * @throws FileReadingException The BufferedReader was unable to read a line
     */
    private String stringFromBufferedInputStream(BufferedInputStream stream) throws FileReadingException {
        StringBuilder stringBuilder = new StringBuilder();
        String line;
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(stream, "utf-8"));
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line);
            }
            bufferedReader.close();
            return stringBuilder.toString();
        } catch (UnsupportedEncodingException e) {
            throw new FileReadingException("Unsupported encoding provided to the InputStreamReader: " + e.getMessage());
        } catch (IOException e) {
            throw new FileReadingException("The BufferedReader was unable to read a line: " + e.getMessage());
        }
    }
}
