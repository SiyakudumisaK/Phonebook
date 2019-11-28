package com.pwc.phonebook.input;

import com.pwc.phonebook.commands.AddCommand;
import com.pwc.phonebook.commands.CompareCommand;
import com.pwc.phonebook.commands.NoOpCommand;
import com.pwc.phonebook.commands.ShowCommand;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class InputParserTest {

    @Test
    void addCommandParsedCorrectly() {
        InputParser inputParser = new InputParser();
        assertTrue(inputParser.apply("ADD foo,232") instanceof AddCommand);
    }

    @Test
    void showCommandParsedCorrectly() {
        InputParser inputParser = new InputParser();
        assertTrue(inputParser.apply("Show") instanceof ShowCommand);
    }

    @Test
    void compareCommandParsedCorrectly() {
        InputParser inputParser = new InputParser();
        assertTrue(inputParser.apply("Compare foobar") instanceof CompareCommand);
    }

    @Test
    void unknownCommandParsedCorrectly() {
        InputParser inputParser = new InputParser();
        assertTrue(inputParser.apply("foobar") instanceof NoOpCommand);
    }
}