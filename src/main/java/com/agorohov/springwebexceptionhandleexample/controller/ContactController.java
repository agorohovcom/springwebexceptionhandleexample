package com.agorohov.springwebexceptionhandleexample.controller;

import com.agorohov.springwebexceptionhandleexample.exception.ContactIsAlreadyAddedException;
import com.agorohov.springwebexceptionhandleexample.exception.ContactNotFoundException;
import com.agorohov.springwebexceptionhandleexample.model.Contact;
import com.agorohov.springwebexceptionhandleexample.service.ContactService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Map;

@RestController
@RequestMapping(value = "/contact", produces = MediaType.APPLICATION_JSON_VALUE)
public class ContactController {
    private static final Logger log = LoggerFactory.getLogger(ContactController.class);

    private final ContactService service;

    public ContactController(ContactService service) {
        this.service = service;
    }

    @GetMapping("/add")
    public Contact addContact(@RequestParam String fullName, @RequestParam String phoneNumber) {
        return service.addContact(fullName, phoneNumber);
    }

    @GetMapping("/remove")
    public Contact removeContact(@RequestParam String fullName) {
        return service.removeContactByFullName(fullName);

    }

    @GetMapping("/get")
    public Contact getByFullName(@RequestParam String fullName) {
        return service.getContactByFullName(fullName);
    }

    @GetMapping
    public Map<String, Contact> getAllContacts() {
        return service.getAllContacts();
    }

    @ExceptionHandler({ContactIsAlreadyAddedException.class, ContactNotFoundException.class})
    public String handleException(Throwable e) {
        log.warn(e.getMessage());
        return LocalDate.now() + " " + e.getMessage();
    }
}
