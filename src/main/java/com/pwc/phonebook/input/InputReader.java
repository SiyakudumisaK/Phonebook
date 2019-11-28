package com.pwc.phonebook.input;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.logging.Logger;
import java.util.stream.Stream;

/**
 * Reads the users input. The class takes the arguments provided to the program and either
 * reads the file provided as a parameter or reads the input from StdIn if no file was given.
 * The input is provided as stream of strings, each representing one command string.
 */

public class InputReader implements Function<String[], Stream<String>> {

    private final static Logger LOGGER = Logger.getLogger(InputReader.class.getName());

    @Override
    public Stream<String> apply(String[] args) {
        Stream<String> stream;

        switch (args.length) {
            case 0:
                stream = stdInStream();
                break;
            case 1:
                stream = readFromFile(args[0]);
                break;
            default:
                LOGGER.severe("Invalid number of arguments. Must be either empty or one filename.");
                stream = Stream.empty();
        }

        return stream;
    }

    /**
     * Read input from a file
     * @param inputFileName
     * @return
     */

    public Stream<String> readFromFile(String inputFileName)
    {
        try{

            return Files.lines(Paths.get(inputFileName));

        } catch (IOException ioe) {
            ioe.printStackTrace();
            throw new RuntimeException(ioe.getMessage());
        }
    }
    /**
     * Reads input from StdIn.
     * @return
     */
    private Stream<String> stdInStream() {
        Scanner scanner = new Scanner(System.in);
        List<String> result = new ArrayList<>();

        System.out.println("Usage: ADD <Name>,<PhoneNumber>");
        System.out.println("Usage: SHOW");
        System.out.println("Usage: COMPARE {Name1, Name2 ..}");
        System.out.println("Please enter a command");
        System.out.println("To complete the input and start execution, press enter and type 'CTRL + D' (Unix) or " +
                "'CTRL + Z' + 'Return' (Windows).");
        System.out.println();

        while (scanner.hasNext()) {
            result.add(scanner.nextLine());
        }

        return result.stream();
    }

}
