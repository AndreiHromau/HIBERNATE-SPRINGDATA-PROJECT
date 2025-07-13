package org.example.hibernatespringdata.dao;

import org.example.hibernatespringdata.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service //@Service в Spring — это специализация аннотации @Component.
// Service используется для обозначения класса как поставщика сервисов.
public class ContactServiceImpl implements ContactService {

    @Autowired //используется для автоматического внедрения зависимостей в классы представляет необходимые beans
    private ContactRepository contactRepository;

    @Override
    public User getContactById(Long id) {
        Optional<User> user = contactRepository.findById(id);
        return user.orElse(null);
    }

    @Override
    public User addContact(User user) {
        return contactRepository.save(user);
    }

    @Override
    public User updatePhoneNumber(Long id, String phoneNumber) {
        Optional<User> optionalUser = contactRepository.findById(id);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            user.setPhoneNumber(phoneNumber);
            return contactRepository.save(user);
        }
        return null;
    }

    @Override
    public void deleteContact(Long id) {
        contactRepository.deleteById(id);
    }
}
