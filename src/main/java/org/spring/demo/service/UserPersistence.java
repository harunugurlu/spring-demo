package org.spring.demo.service;

import org.spring.demo.model.Store;
import org.spring.demo.model.User;

public class UserPersistence {

    private Store store = new Store();

    public void saveUser(User user) {
        store.store(user);
    }
}
