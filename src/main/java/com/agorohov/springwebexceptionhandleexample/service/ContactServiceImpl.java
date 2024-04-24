package com.agorohov.springwebexceptionhandleexample.service;

import com.agorohov.springwebexceptionhandleexample.exception.ContactIsAlreadyAddedException;
import com.agorohov.springwebexceptionhandleexample.exception.ContactNotFoundException;
import com.agorohov.springwebexceptionhandleexample.model.Contact;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Service
public class ContactServiceImpl implements ContactService {

    private final Map<String, Contact> contactMap;

    public ContactServiceImpl() {
        this.contactMap = new HashMap<>();
    }

    @Override
    public Contact addContact(String fullName, String phoneNumber) {
        if (contactMap.containsKey(fullName)) {
            throw new ContactIsAlreadyAddedException("Уже есть контакт с именем " + fullName);
        }
        Contact contact = new Contact(fullName, phoneNumber);
        contactMap.put(fullName, new Contact(fullName, phoneNumber));
        return contact;
    }

    @Override
    public Contact removeContactByFullName(String fullName) {
        if (!contactMap.containsKey(fullName)) {
            throw new ContactNotFoundException("Нет контакта с именем " + fullName + ", удаление невозможно");
        }
        return contactMap.remove(fullName);
    }

    @Override
    public Contact getContactByFullName(String fullName) {
        if (!contactMap.containsKey(fullName)) {
            throw new ContactNotFoundException("Нет контакта с именем " + fullName);
        }
        return contactMap.get(fullName);
    }

    @Override
    public Map<String, Contact> getAllContacts() {
        return Collections.unmodifiableMap(contactMap);
    }
}
