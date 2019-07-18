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

    public String getFileContentsAsString(String filePath) throws FileReadingException {
        FileReader reader = new FileReader();
        return reader.fileContentsAsString(filePath);
    }
}
