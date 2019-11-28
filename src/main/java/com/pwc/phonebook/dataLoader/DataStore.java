package com.pwc.phonebook.dataLoader;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pwc.phonebook.entity.PhoneBook;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.TreeMap;

/**
 * Utility class to handle file read-write
 */
public class DataStore {

    private static ObjectMapper mapper = new ObjectMapper();

    public static TreeMap<String, String> loadData(String pathname) {
        TreeMap<String, String> map = new TreeMap<>();
        try {
            File file = new File(pathname);
            if (file.length() != 0) {
                List<PhoneBook> phoneBookList = mapper.readValue(file,
                        new TypeReference<List<PhoneBook>>(){});
                phoneBookList.forEach(phoneBook ->
                        map.put(phoneBook.getName(), phoneBook.getPhoneNumber()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return map;
    }

    public static void writeToFile(List<PhoneBook> phoneBookList, String fileName) {
        try(FileWriter fileWriter = new FileWriter(fileName)) {
            fileWriter.append(mapper.writeValueAsString(phoneBookList));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
