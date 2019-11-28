package com.pwc.phonebook.commands;

import com.pwc.phonebook.repository.PhoneBookRepository;

/**
 * Commands take an instance of the repository and performs action on it
 * based on their respective implementation.
 */

public interface Command {

    void execute(PhoneBookRepository repository);
}
