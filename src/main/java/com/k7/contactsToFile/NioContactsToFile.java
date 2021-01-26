package com.k7.contactsToFile;

import com.k7.contacts.Contact;
import com.k7.contacts.ContactType;
import com.k7.service.ContactsService;
import lombok.AllArgsConstructor;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@AllArgsConstructor
public class NioContactsToFile implements ContactsToFile {
    private ContactsService contactsService;

    @Override
    public void read() {
        try (SeekableByteChannel channel = Files.newByteChannel(Path.of("src/main/resources/contacts.txt"))) {
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            channel.read(buffer);
            buffer.flip();
            for (String s : new String(buffer.array(), 0, buffer.limit()).split("\n")) {
                contactsService.add(parse(s));
            }
            buffer.clear();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void write() {
        try (SeekableByteChannel channel = Files.newByteChannel(
                Path.of("src/main/resources/contacts.txt"),
                StandardOpenOption.WRITE)) {
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            for (Contact c : contactsService.getAll().get()) {
                buffer.put(new String(c.getName() + "[" + c.getContactType() + ":" + c.getPhone() + "]\n")
                        .getBytes());
            }
            buffer.flip();
            channel.write(buffer);
            buffer.clear();
        } catch (IOException e) {
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
