package com.k7.contactsToFile;

import com.k7.contacts.Contact;
import com.k7.contacts.ContactType;
import com.k7.service.ContactsService;
import lombok.AllArgsConstructor;

import java.io.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@AllArgsConstructor
public class IoContactsToFile implements ContactsToFile {
    private ContactsService contactsService;

    @Override
    public void read() {
        File file = new File("src/main/resources/contacts.txt");
        try (Reader reader = new FileReader(file)) {
            Scanner sc = new Scanner(reader);
            while (sc.hasNext()) {
                contactsService.add(parse(sc.nextLine()));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void write() {
        File file = new File("src/main/resources/contacts.txt");
        try (PrintWriter writer = new PrintWriter(new FileOutputStream(file))) {
            for (Contact c : contactsService.getAll().get()) {
                writer.write(c.getName() + "[" + c.getContactType() + ":" + c.getPhone() + "]\n");
                writer.flush();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private boolean checkPhone(String phone) {
        String regex = "(\\+380)(\\d{9})";
        return phone.matches(regex);
    }

    private Contact parse(String user) {
        Pattern pattern = Pattern.compile("(?:(.+)\\[)(?:(.+):)(?:(.+)\\])");
        Matcher matcher = pattern.matcher(user);
        Contact parsedUser = null;
        if ((!matcher.matches())) {
            System.out.println(user + " - Invalid user!");
            return null;
        } else {
            parsedUser = new Contact(matcher.group(1), ContactType.valueOf(matcher.group(2)), matcher.group(3));
        }
        return parsedUser;
    }
}
