/**
 * 'FileReadingException.java'
 *
 * Specific exception for file reading problems.
 *
 * 2019 Steve Neale <steveneale3000@gmail.com>
 */

package com.steveneale.textprocessor.exceptions;

public class FileReadingException extends Exception {

    public FileReadingException(String errorMessage) {
        super(errorMessage);
    }

}
