package com.k7.contacts;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ContactsList {
    private List<Contact> contacts = new ArrayList<>();

    public boolean checkIndex(int index) {
        return (index >= contacts.size() || index < 0);
    }

    public Contact get(int index) {
        return contacts.get(index);
    }

    public void set(int index, Contact c) {
        //checkIndex(index);
        contacts.set(index, c);
    }

    public void add(Contact c) {
        contacts.add(c);
    }


    public void remove(int index) {
        contacts.remove(index);
    }

    public int size() {
        return contacts.size();
    }

    public List<Contact> getByName(String name) {
        return (contacts.stream()
                .filter(s -> s.getName().startsWith(name))
                .collect(Collectors.toList()));
    }

    public List<Contact> getByPhone(String phone) {
        return (contacts.stream()
                .filter(s -> s.getPhone().indexOf(phone) != -1)
                .collect(Collectors.toList()));
    }

    public List<Contact> get() {
        return (contacts.stream()
                .collect(Collectors.toList()));
    }
}
