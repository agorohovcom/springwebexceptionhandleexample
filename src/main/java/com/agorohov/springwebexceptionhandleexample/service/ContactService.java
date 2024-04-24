package com.agorohov.springwebexceptionhandleexample.service;

import com.agorohov.springwebexceptionhandleexample.model.Contact;

import java.util.Map;

public interface ContactService {
    Contact addContact(String fullName, String phoneNumber);

    Contact removeContactByFullName(String fullName);

    Contact getContactByFullName(String fullName);

    Map<String, Contact> getAllContacts();
}
