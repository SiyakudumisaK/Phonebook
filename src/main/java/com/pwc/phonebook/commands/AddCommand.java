package com.pwc.phonebook.commands;

import com.pwc.phonebook.entity.PhoneBook;
import com.pwc.phonebook.repository.PhoneBookRepository;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * AddCommand is initialized by the InputParser with the user input. It then extracts name and phone number and creates
 * an object to store in the repo.
 */
public class AddCommand implements Command {

  private static final Pattern ADD_REGEX = Pattern.compile("(ADD|add|Add)\\s([a-zA-Z]*),\\s*(\\d+)");
  private final String commandString;

  public AddCommand(String commandString) {
    this.commandString = commandString;
  }

  @Override
  public void execute(PhoneBookRepository repository) {
    Matcher matcher = ADD_REGEX.matcher(commandString);
    if (matcher.matches()) {
      PhoneBook phoneBook = new PhoneBook(matcher.group(2).trim().toUpperCase(),matcher.group(3));
      repository.save(phoneBook);
    }
  }
}
