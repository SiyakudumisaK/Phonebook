package com.pwc.phonebook.repository;

import com.pwc.phonebook.entity.PhoneBook;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.TreeMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PhoneBookRepositoryImplTest {

    private PhoneBookRepositoryImpl phoneBookRepository;
    private TreeMap<String, String> map = new TreeMap<>();

    @BeforeEach
    public void setup() {
        phoneBookRepository = new PhoneBookRepositoryImpl(map);
    }

    @Test
    void repositoryFunctionsAsExpected() {
        PhoneBook expected = new PhoneBook("foo", "123");
        phoneBookRepository.save(expected);
        assertEquals(1, map.size());
        map.forEach((key, value) -> {
            assertEquals(expected.getName(), key);
            assertEquals(expected.getPhoneNumber(), value);
        });
    }

    @Test
    void findAll() {
        PhoneBook expected = new PhoneBook("foo", "123");
        phoneBookRepository.save(expected);
        List<PhoneBook> phoneBooks = phoneBookRepository.findAll();
        assertEquals(1, phoneBooks.size());
        assertEquals(expected, phoneBooks.get(0));
    }
}