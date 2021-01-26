package com.k7.menuAction;

import com.k7.contactsToFile.ContactsToFile;
import com.k7.service.ContactsService;
import lombok.AllArgsConstructor;

import java.util.Scanner;

@AllArgsConstructor
public class RemoveContactMenuAction implements MenuAction {
    private ContactsService contactsService;
    private Scanner sc;
    private ContactsToFile contactsToFile;

    @Override
    public void doAction() {
//        System.out.println("Enter contact's list number for delete");
//        int index = sc.nextInt() - 1;
//        sc.nextLine();
//        while (contactsService.getAll().checkIndex(index)) {
//            System.out.println("Invalid index. Repeat action.");
//            return;
//        }
//        System.out.println(contactsService.getAll().get(index).getName() + " deleted");
        // System.out.println("------------------------");
        // contactsService.remove(name);
        System.out.println("Enter contact's name for delete");
        String name = sc.nextLine();
        for (int i = 0; i < contactsService.getAll().size(); i++) {
            if (contactsService.getAll().get(i).getName().equals(name)) {
                contactsService.remove(i);
                continue;
            }
        }
        System.out.println(name + " deleted");

        contactsToFile.write();
    }

    @Override
    public String getName() {
        return "Delete contact";
    }

    @Override
    public boolean closeAfter() {
        return false;
    }
}
