package com.k7.service;

import com.k7.contacts.Contact;
import com.k7.contacts.ContactsList;

public class InMemoryContactsService implements ContactsService {
    private ContactsList contactsList = new ContactsList();

    @Override
    public ContactsList getAll() {
        return contactsList;
    }

    @Override
    public void remove(int index) {
        contactsList.remove(index);
    }

    @Override
    public void add(Contact c) {
        contactsList.add(c);
    }
}
