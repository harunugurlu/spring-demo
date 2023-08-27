package org.spring.demo.service;

import org.spring.demo.model.Store;
import org.spring.demo.model.User;

public class UserValidator {
    private Store store = new Store();
    public User isValidUser(String name) {
        User existingUser = store.getUser(name);
        return existingUser;
    }
}
