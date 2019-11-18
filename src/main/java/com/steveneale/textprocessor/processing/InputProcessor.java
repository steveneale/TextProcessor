/**
 * 'InputProcessor.java'
 *
 * Process input file(s) in a given language.
 *
 * 2019 Steve Neale <steveneale3000@gmail.com>
 */

package com.steveneale.textprocessor.processing;

import com.steveneale.textprocessor.exceptions.FileReadingException;
import com.steveneale.textprocessor.io.FileReader;


public class InputProcessor {

    /**
     * Get the contents of a file as a String
     *
     * @param filePath              Path to a file whose contents should be returned
     * @return                      Contents of the file as a String
     * @throws FileReadingException Unsupported encoding provided to the InputStreamReader
     * @throws FileReadingException The BufferedReader was unable to read a line
     */
    public String getFileContentsAsString(String filePath) throws FileReadingException {
        FileReader reader = new FileReader();
        return reader.fileContentsAsString(filePath);
    }
}
