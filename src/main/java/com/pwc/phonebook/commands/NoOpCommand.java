package com.pwc.phonebook.commands;

import com.pwc.phonebook.repository.PhoneBookRepository;

/**
 * NoOpCommand is used to handle unknown user inputs.
 */
public class NoOpCommand implements Command {

  private final String commandString;

  public NoOpCommand(String commandString) {
    this.commandString = commandString;
  }

  @Override
  public void execute(PhoneBookRepository repository) {
    System.out.println(commandString + " is not a known Command!");
  }
}
