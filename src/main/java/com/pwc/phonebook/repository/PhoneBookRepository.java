package com.pwc.phonebook.repository;

import com.pwc.phonebook.entity.PhoneBook;
import java.util.List;

/**
 * Interface for the Repository. This enables possible implementation of the repository class using JPA.
 */
public interface PhoneBookRepository {

  void save(PhoneBook phoneBook);
  List<PhoneBook> findAll();

}
