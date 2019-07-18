/**
 * 'CommandLineArgumentParser.java'
 *
 * Parse arguments passed using the command line, and return their values.
 *
 * 2019 Steve Neale <steveneale3000@gmail.com>
 */

package com.steveneale.textprocessor.utils;

import org.apache.commons.cli.*;


public class CommandLineArgumentParser {

    private static CommandLineParser parser = new BasicParser();
    private static HelpFormatter helpFormatter = new HelpFormatter();
    private static CommandLine commandLine;
    
    public static String[] parseValues(String[] args) {
        Options options = getCommandLineOptions();
        String[] values = new String[options.getOptions().size()];
        
        try {
            commandLine = parser.parse(options, args);
            values[0] = commandLine.getOptionValue("input");
            values[1] = commandLine.getOptionValue("language");
        } catch (ParseException e) {
            System.out.println(e.getMessage());
            helpFormatter.printHelp("utility-name", options);
            System.exit(1);
        }
        
        return values;
    }

    private static Options getCommandLineOptions() {
        Options options = new Options();

        Option input = new Option("i", "input", true, "Input file path");
        input.setRequired(true);
        options.addOption(input);

        Option language = new Option("l", "language", true, "Input text language");
        language.setRequired(true);
        options.addOption(language);
        
        return options;
    }
}