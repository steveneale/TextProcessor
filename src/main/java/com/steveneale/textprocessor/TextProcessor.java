/**
 * 'TextProcessor.java'
 *
 * Process text in given languages.
 *
 * 2019 Steve Neale <steveneale3000@gmail.com>
 */

package com.steveneale.textprocessor;

import com.steveneale.textprocessor.exceptions.FileReadingException;
import com.steveneale.textprocessor.utils.CommandLineArgumentParser;
import com.steveneale.textprocessor.processing.InputProcessor;
import com.steveneale.textprocessor.processing.LanguageProcessor;


public class TextProcessor {
    
    /**
     * Run the TextProcessor
     *
     * @param args Command line arguments
     */
    public static void main(String[] args) {
        String[] arguments = CommandLineArgumentParser.parseValues(args);
        InputProcessor inputProcessor = new InputProcessor();
        LanguageProcessor languageProcessor = new LanguageProcessor(arguments[1]);
        try {
            String inputText = inputProcessor.getFileContentsAsString(arguments[0]);
            String[] sentences = languageProcessor.splitTextIntoSentences(inputText);
            for (int i = 0; i < sentences.length; i++) {
                System.out.println(i+1 + ": " + sentences[i]);
            }
        } catch (FileReadingException e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }
    }
}