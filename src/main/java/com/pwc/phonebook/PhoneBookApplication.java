package com.pwc.phonebook;

import com.pwc.phonebook.dataLoader.DataStore;
import com.pwc.phonebook.input.InputParser;
import com.pwc.phonebook.input.InputReader;
import com.pwc.phonebook.repository.PhoneBookRepository;
import com.pwc.phonebook.repository.PhoneBookRepositoryImpl;

/**
 * The main application initializes the repository with the data from the file and starts delegating tasks to
 * - Input reader
 * - Input Parser
 * - Command classes
 */
public class PhoneBookApplication {

	private static final String PATHNAME = "data/phonebook.json";

	public static void main(String[] args) {

		PhoneBookRepository phoneBookRepository = new PhoneBookRepositoryImpl(DataStore.loadData(PATHNAME));
		new InputReader().apply(args)
				.map(new InputParser())
				.forEach(command -> command.execute(phoneBookRepository));


		DataStore.writeToFile(phoneBookRepository.findAll(), PATHNAME);
	}
}
