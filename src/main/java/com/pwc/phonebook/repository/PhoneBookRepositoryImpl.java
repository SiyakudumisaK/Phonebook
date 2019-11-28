package com.pwc.phonebook.repository;

import com.pwc.phonebook.entity.PhoneBook;
import java.util.List;
import java.util.TreeMap;
import java.util.stream.Collectors;

/**
 * Implementation of the repository functionality.
 */
public class PhoneBookRepositoryImpl implements PhoneBookRepository {

  private TreeMap<String, String> phoneBookRepo;

  public PhoneBookRepositoryImpl() {

  }

  public PhoneBookRepositoryImpl(TreeMap<String, String> phoneBookRepo) {
    this.phoneBookRepo = phoneBookRepo;
  }

  @Override
  public void save(PhoneBook phoneBook) {
    phoneBookRepo.put(phoneBook.getName(), phoneBook.getPhoneNumber());
  }

  @Override
  public List<PhoneBook> findAll() {
    return phoneBookRepo.entrySet().stream().map(entry -> new PhoneBook(entry.getKey(), entry.getValue())).collect(
        Collectors.toList());
  }

}
