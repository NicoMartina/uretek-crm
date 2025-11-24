package com.uretek_crm.uretek_crm.controller;


import com.uretek_crm.uretek_crm.model.Contact;
import com.uretek_crm.uretek_crm.services.ContactService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/contact")
public class ContactController {
    private final ContactService contactService;

    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @PostMapping
    public Contact createContact(@RequestBody Contact newContact) {
        return contactService.save(newContact);
    }

    @GetMapping("/{contactId}")
    public ResponseEntity<Contact> getContactById(@PathVariable Long contactId) {
        Optional<Contact> contact = contactService.findById(contactId);
        return contact.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<Contact> getContactByName(@RequestParam(name = "name") String contactName) {
        Optional<Contact> contact = contactService.findByName(contactName);
        return contact.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{contactId")
    public Contact updateContact(@PathVariable Long contactId, @RequestBody Contact updatedContact) {
        return contactService.updateContact(contactId, updatedContact);
    }

    @DeleteMapping("/contactId")
    public ResponseEntity<Void> deleteContact(@PathVariable Long contactId) {
        contactService.deleteById(contactId);
        return ResponseEntity.noContent().build();
    }

}
