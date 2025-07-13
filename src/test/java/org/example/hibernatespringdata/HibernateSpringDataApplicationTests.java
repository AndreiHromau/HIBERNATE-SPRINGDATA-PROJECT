package org.example.hibernatespringdata;

import org.example.hibernatespringdata.dao.ContactService;
import org.example.hibernatespringdata.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class HibernateSpringDataApplicationTests {

    @Autowired //используется для автоматического внедрения зависимостей в классы
    private ContactService contactService;

    @Test
    void addAndRetrieveContact() {
        User newUser = new User(null, "Andrei", "Hromau", "11111111", "andreihromau@gmail.com");
        User addedUser = contactService.addContact(newUser);

        assertThat(addedUser.getId()).isNotNull();
        User retrievedUser = contactService.getContactById(addedUser.getId());

        assertThat(retrievedUser)
                .isNotNull()
                .extracting(User::getFirstName, User::getLastName, User::getPhoneNumber, User::getEmail)
                .containsExactly("Andrei", "Hromau", "11111111", "andreihromau@gmail.com");
    }

    @Test
    void updatePhoneNumber() {
        User newUser = new User(null, "Andrei", "Hromau", "11111111", "andreihromau@gmail.com");
        User addedUser = contactService.addContact(newUser);

        String newPhoneNumber = "22222222";
        User updatedUser = contactService.updatePhoneNumber(addedUser.getId(), newPhoneNumber);

        assertThat(updatedUser).isNotNull();
        assertThat(updatedUser.getPhoneNumber()).isEqualTo(newPhoneNumber);
    }

    @Test
    void deleteContact() {
        User newUser = new User(null, "Andrei", "Hromau", "22222222", "andreihromau@gmail.com");
        User addedUser = contactService.addContact(newUser);

        contactService.deleteContact(addedUser.getId());

        User deletedUser = contactService.getContactById(addedUser.getId());
        assertThat(deletedUser).isNull();
    }
}
