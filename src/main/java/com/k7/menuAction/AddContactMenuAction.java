package com.k7.menuAction;

import com.k7.contacts.Contact;
import com.k7.contacts.ContactType;
import com.k7.contactsToFile.ContactsToFile;
import com.k7.service.ContactsService;
import lombok.AllArgsConstructor;

import java.util.Scanner;

@AllArgsConstructor
public class AddContactMenuAction implements MenuAction {
    private ContactsService contactsService;
    private Scanner sc;
    private ContactsToFile contactsToFile;

    @Override
    public void doAction() {
//        System.out.println("Enter name of contact");
//        String name = sc.nextLine();
//        System.out.println("Enter phone number");
//        String phone = sc.nextLine();
//        while (!checkPhone(phone)) {
//            System.out.println("Phone number must have +380xxxxxxx format!\nEnter phone number");
//            phone = sc.nextLine();
//        }
//            contactsService.add(new Contact(name, phone));

        contactsService.add(new Contact("Петя", ContactType.email, "prtya@gmail.com"));
        contactsService.add(new Contact("Оля", ContactType.phone, "+3806131772141"));
        contactsService.add(new Contact("Катя", ContactType.email, "katya@gmail.com"));
        contactsService.add(new Contact("Олег", ContactType.phone, "+3806131471193"));
        System.out.println("Contacts added");
        System.out.println("------------------------");
        contactsToFile.write();
    }

    private boolean checkPhone(String phone) {
        String regex = "(\\+380)(\\d{9})";
        return phone.matches(regex);
    }

    @Override
    public String getName() {
        return "Add contact";
    }

    @Override
    public boolean closeAfter() {
        return false;
    }
}
