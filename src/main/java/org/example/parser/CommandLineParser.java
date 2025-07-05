package org.example.parser;

import org.example.application.ApplicationException;
import org.example.config.Options;

public class CommandLineParser {
    public void parse(String[] args, Options options) throws ApplicationException {
        try {
            for (int i = 0; i < args.length; i++) {
                String arg = args[i];
                switch (arg) {
                    case "-o":
                        if (i + 1 >= args.length) throw new ApplicationException("Missing path after -o option");
                        options.setOutputPath(args[++i]);
                        break;
                    case "-p":
                        if (i + 1 >= args.length) throw new ApplicationException("Missing prefix after -p option");
                        options.setFilePrefix(args[++i]);
                        break;
                    case "-a":
                        options.setAppendMode(true);
                        break;
                    case "-f":
                        options.setFullStatistics(true);
                        break;
                    case "-s":
                        options.setShortStatistics(true);
                        break;
                    default:
                        if (arg.startsWith("-")) throw new ApplicationException("Unknown option: " + arg);
                        options.addInputFile(arg);
                        break;
                }
            }

            if (!options.isFullStatistics() && !options.isShortStatistics()) {
                options.setShortStatistics(true);
            }
        } catch (Exception e) {
            throw new ApplicationException("Error parsing arguments: " + e.getMessage());
        }
    }
}