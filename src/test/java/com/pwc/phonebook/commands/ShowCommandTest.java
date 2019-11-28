package com.pwc.phonebook.commands;

import com.pwc.phonebook.entity.PhoneBook;
import com.pwc.phonebook.repository.PhoneBookRepositoryImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

public class ShowCommandTest {

    @Mock
    private PhoneBookRepositoryImpl phoneBookRepository;
    private ShowCommand showCommand;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        showCommand = new ShowCommand();
    }

    @Test
    public void test() {
        when(phoneBookRepository.findAll()).thenReturn(Collections.singletonList(new PhoneBook()));
        showCommand.execute(phoneBookRepository);
        verify(phoneBookRepository, times(1)).findAll();
    }
}