package com.k7.menuAction;

import com.k7.service.ContactsService;

import java.util.Set;
import java.util.stream.Collectors;

public class ReadAllContactsMenuAction implements MenuAction {
    private ContactsService contactsService;

    public ReadAllContactsMenuAction(ContactsService contactsService) {
        this.contactsService = contactsService;
    }

    @Override
    public void doAction() {
        try {
        int nom = 1;
        System.out.println("------Contact list------");
            Set<String> names = contactsService.getAll().get().stream()
                    .map(s -> s.getName())
                    .collect(Collectors.toSet());
            for (String s : names) {
                System.out.println(nom + ". " + s + ":");
                for (int i = 0; i < contactsService.getAll().size(); i++) {
                    if (s.equals(contactsService.getAll().get(i).getName())) {
                        System.out.println("     " + contactsService.getAll().get(i).getContactType() + ":"
                                + contactsService.getAll().get(i).getPhone());
                    }
                }
                ++nom;
            }
            System.out.println("------------------------");
        }catch (NullPointerException e) {
            System.out.println("No contacts");
        }
    }

    @Override
    public String getName() {
        return "Show all contacts";
    }

    @Override
    public boolean closeAfter() {
        return false;
    }
}
