/**
 * 'FileReadingException.java'
 *
 * Specific exception for file reading problems.
 *
 * 2019 Steve Neale <steveneale3000@gmail.com>
 */

package com.steveneale.textprocessor.exceptions;

public class FileReadingException extends Exception {

    /**
     * Throw a FileReadingException
     *
     * @param errorMessage A message outlining the cause of the exception
     */
    public FileReadingException(String errorMessage) {
        super(errorMessage);
    }

}
