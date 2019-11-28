package com.pwc.phonebook.commands;

import com.pwc.phonebook.repository.PhoneBookRepository;

/**
 * ShowCommand is initialized by the InputParser with the user input. It then retrieves the records in the current repo
 * and displays them.
 */
public class ShowCommand implements Command {

  @Override
  public void execute(PhoneBookRepository repository) {
    System.out.println("Current content of the phone book: ");
    repository.findAll().forEach(System.out::println);
  }
}
