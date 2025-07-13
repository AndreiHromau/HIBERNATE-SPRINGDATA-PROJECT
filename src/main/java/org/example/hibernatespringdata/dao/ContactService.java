package org.example.hibernatespringdata.dao;

import org.example.hibernatespringdata.model.User;

public interface ContactService {
    User getContactById(Long id);
    User addContact(User user);
    User updatePhoneNumber(Long id, String phoneNumber);
    void deleteContact(Long id);
}
