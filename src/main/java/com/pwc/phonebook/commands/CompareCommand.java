package com.pwc.phonebook.commands;

import com.pwc.phonebook.entity.PhoneBook;
import com.pwc.phonebook.repository.PhoneBookRepository;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * CompareCommand is initialized by the InputParser with the user input. It then extracts names and retrieves the current
 * name list from the repo and evaluates the unique names.
 */
public class CompareCommand implements Command {

  private static final Pattern COMPARE_REGEX = Pattern.compile("(Compare|COMPARE|compare)\\s\\{(.*?)}");
  private final String commandString;

  public CompareCommand(String commandString) {
    this.commandString = commandString;
  }

  @Override
  public void execute(PhoneBookRepository repository) {
    Matcher matcher = COMPARE_REGEX.matcher(commandString);
    if (matcher.matches()) {
      String names = matcher.group(2);
      Set<String> nameSet = Arrays.stream(names.split(","))
              .map(String::trim)
              .map(String::toUpperCase)
              .collect(Collectors.toSet());
      Set<String> currentNameSet = repository.findAll().stream().map(PhoneBook::getName).collect(Collectors.toSet());
      Set<String> differenceA = new HashSet<>(nameSet);
      differenceA.removeAll(currentNameSet);
      Set<String> differenceB = new HashSet<>(currentNameSet);
      differenceB.removeAll(nameSet);
      differenceA.addAll(differenceB);
      System.out.println("Friends that are unique to each of " + currentNameSet + " and " + nameSet + " lists are: ");
      differenceA.forEach(System.out::println);
    }
  }
}
