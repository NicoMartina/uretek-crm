package com.uretek_crm.uretek_crm.controller;


import com.uretek_crm.uretek_crm.model.Contact;
import com.uretek_crm.uretek_crm.services.ContactService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/contacts")
public class ContactController {
    private final ContactService contactService;

    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Contact createContact(@RequestBody Contact newContact) {
        return contactService.save(newContact);
    }

    @GetMapping
    public List<Contact> getAllContacts(){
        return contactService.findAll();
    }

    @GetMapping("/{contactId}")
    public ResponseEntity<Contact> getContactById(@PathVariable Long contactId) {
        Optional<Contact> contact = contactService.findById(contactId);
        return contact.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping(params = "name")
    public ResponseEntity<Contact> getContactByName(@RequestParam String contactName) {
        Optional<Contact> contact = contactService.findByName(contactName);
        return contact.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{contactId")
    public Contact updateContact(@PathVariable Long contactId, @RequestBody Contact updatedContact) {
        return contactService.updateContact(contactId, updatedContact);
    }

    @DeleteMapping("/contactId")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Void> deleteContact(@PathVariable Long contactId) {
        contactService.deleteById(contactId);
        return ResponseEntity.noContent().build();
    }

}
