package com.uretek_crm.uretek_crm.services;

import com.uretek_crm.uretek_crm.model.Contact;
import com.uretek_crm.uretek_crm.repository.ContactRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactService {

    private final ContactRepository contactRepository;

    public ContactService(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    //CREATE
    public Contact save(Contact contact) {
        return contactRepository.save(contact);
    }



    //READ
    public List<Contact> findAll() { return contactRepository.findAll();}

    public Optional<Contact> findById(Long id) { return contactRepository.findById(id); }

    public Optional<Contact> findByName(String name) { return contactRepository.findByName(name); }



    //UPDATE
    public Contact updateContact(Long id, Contact updatedContact){
        Contact existingContact = contactRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Contact with ID " + " not found."));


        if (updatedContact.getName() != null) {
            existingContact.setName(updatedContact.getName());
        }

        if (updatedContact.getPhoneNumber() != null){
            existingContact.setPhoneNumber(updatedContact.getPhoneNumber());
        }

        if (updatedContact.getEmail() != null) {
            existingContact.setEmail(updatedContact.getEmail());
        }

        if (updatedContact.getAddress() != null) {
            existingContact.setAddress((updatedContact.getAddress()));
        }

        return contactRepository.save(existingContact);
    }

    //DELETE
    public void deleteById(Long id) { contactRepository.deleteById(id); }


}
