package com.k7.menuAction;

import com.k7.contacts.Contact;
import com.k7.service.ContactsService;
import lombok.AllArgsConstructor;

import java.util.Scanner;

@AllArgsConstructor
public class SearchByPhoneContactsMenuAction implements MenuAction {
    private ContactsService contactsService;
    private Scanner sc;

    @Override
    public void doAction() {
        int num = 0;
        System.out.println("Enter the part of phone number");
        String search = sc.nextLine();
        System.out.println("------Contact list------");
        for (Contact contact : contactsService.getAll().getByPhone(search)) {
            System.out.println(++num + ". " + contact.toString());
        }
        System.out.println("------------------------");
    }

    @Override
    public String getName() {
        return "Search contact by phone number";
    }

    @Override
    public boolean closeAfter() {
        return false;
    }
}
