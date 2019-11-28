package com.pwc.phonebook.dataLoader;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pwc.phonebook.entity.PhoneBook;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DataStoreTest {

    private static ObjectMapper mapper = new ObjectMapper();

    @Test
    public void dataLoadsProperly() {
        String fileName = "data.json";
        File file = new File(fileName);
        try(FileWriter fileWriter = new FileWriter(file)) {
            fileWriter.append("[{\"name\":\"foo\",\"phoneNumber\":\"111\"},{\"name\":\"bar\",\"phoneNumber\":\"123\"}]");
        } catch (IOException e) {
            e.printStackTrace();
        }
        TreeMap<String, String> actual = DataStore.loadData(fileName);

        assertEquals(2, actual.size());
        assertEquals("111", actual.get("foo"));
        assertEquals("123", actual.get("bar"));

        file.delete();
    }

    @Test
    public void dataSavesProperly() {
        String fileName = "data.json";
        File file = new File(fileName);

        List<PhoneBook> phoneBooks = new ArrayList<>();
        phoneBooks.add(new PhoneBook("foo", "111"));
        phoneBooks.add(new PhoneBook("bar", "123"));

        DataStore.writeToFile(phoneBooks, fileName);

        StringBuilder contentBuilder = new StringBuilder();
        try (Stream<String> stream = Files.lines( Paths.get(fileName), StandardCharsets.UTF_8)) {
            stream.forEach(contentBuilder::append);
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertEquals("[{\"name\":\"foo\",\"phoneNumber\":\"111\"},{\"name\":\"bar\",\"phoneNumber\":\"123\"}]",
                contentBuilder.toString());

        file.delete();
    }

}