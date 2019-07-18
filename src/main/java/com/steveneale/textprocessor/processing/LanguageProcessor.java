/**
 * 'LanguageProcessor.java'
 *
 * Process natural language text strings.
 *
 * 2019 Steve Neale <steveneale3000@gmail.com>
 */

package com.steveneale.textprocessor.processing;

import com.steveneale.textprocessor.exceptions.FileReadingException;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import opennlp.tools.sentdetect.SentenceModel;
import opennlp.tools.sentdetect.SentenceDetectorME;


public class LanguageProcessor {

    private String language;

    public LanguageProcessor(String language) {
        this.language = language;
    }

    public String[] splitTextIntoSentences(String inputText) throws FileReadingException {
        try (InputStream modelIn = new FileInputStream("resources/opennlp_models/" +
                                                       this.language + "/" + this.language + "-sent.bin")) {
            SentenceModel sentenceModel = new SentenceModel(modelIn);
            SentenceDetectorME sentenceDetector = new SentenceDetectorME(sentenceModel);
            return sentenceDetector.sentDetect(inputText);
        } catch (IOException e) {
            throw new FileReadingException("The given SentenceModel could not be loaded: " + e.getMessage());
        }
    }
}
