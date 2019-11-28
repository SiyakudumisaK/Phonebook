package com.pwc.phonebook.commands;

import com.pwc.phonebook.entity.PhoneBook;
import com.pwc.phonebook.repository.PhoneBookRepositoryImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;


public class AddCommandTest {

    @Spy
    private PhoneBookRepositoryImpl phoneBookRepository;
    private AddCommand addCommand;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        addCommand = new AddCommand("ADD foo,123");
    }

    @Test
    public void test() {

        doNothing().when(phoneBookRepository).save(any());
        addCommand.execute(phoneBookRepository);
        ArgumentCaptor<PhoneBook> phoneBookArgumentCaptor = ArgumentCaptor.forClass(PhoneBook.class);
        verify(phoneBookRepository, times(1)).save(phoneBookArgumentCaptor.capture());
        PhoneBook phoneBook = phoneBookArgumentCaptor.getValue();
        assertEquals("FOO", phoneBook.getName());
        assertEquals("123", phoneBook.getPhoneNumber());
    }

}