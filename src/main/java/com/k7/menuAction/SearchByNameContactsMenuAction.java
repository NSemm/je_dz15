package com.k7.menuAction;

import com.k7.contacts.Contact;
import com.k7.service.ContactsService;
import lombok.AllArgsConstructor;

import java.util.Scanner;

@AllArgsConstructor
public class SearchByNameContactsMenuAction implements MenuAction {
    private ContactsService contactsService;
    private Scanner sc;

    @Override
    public void doAction() {
        try{
        int num = 0;
        System.out.println("Enter the begining of contact name");
        String search = sc.nextLine();
        System.out.println("------Contact list------");
        for (Contact contact : contactsService.getAll().getByName(search)) {
            System.out.println(++num + ". " + contact.toString());
        }
        System.out.println("------------------------");
        }catch (NullPointerException e) {
            System.out.println("No contacts");
        }
    }

    @Override
    public String getName() {
        return "Search contact by name";
    }

    @Override
    public boolean closeAfter() {
        return false;
    }
}
