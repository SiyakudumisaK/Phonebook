package com.pwc.phonebook.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PhoneBook {
    private String name;
    private String phoneNumber;

    @Override
    public String toString() {
        return name + " - " + phoneNumber;
    }
}
