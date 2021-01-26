package com.k7.service;

import com.k7.contacts.Contact;
import com.k7.contacts.ContactsList;

public interface ContactsService {
    ContactsList getAll();
    void remove(int index);
    void add(Contact c);
}
