package com.k7.contacts;

public enum ContactType {
    phone(1), email(2);
    int type;

    ContactType(int type) {
        this.type = type;
    }
}
