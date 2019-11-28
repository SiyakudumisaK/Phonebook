package com.pwc.phonebook.input;

import com.pwc.phonebook.commands.*;

import java.util.function.Function;

/**
 * Turns a command string read from the input source into a programmatic command object.
 */
public class InputParser implements Function<String, Command> {

    private static final String ADD = "ADD";
    private static final String SHOW = "SHOW";
    private static final String COMPARE = "COMPARE";

    /**
     *
     * @param inputString
     * @return The corresponding command object.
     */
    @Override
    public Command apply(String inputString){

        if (inputString.toUpperCase().startsWith(ADD)) {
            return new AddCommand(inputString);
        }
        else if (inputString.toUpperCase().equals(SHOW)) {
            return new ShowCommand();
        }
        else if (inputString.toUpperCase().startsWith(COMPARE)) {
            return new CompareCommand(inputString);
        }
        else {
            return new NoOpCommand(inputString);
        }
    }

}
