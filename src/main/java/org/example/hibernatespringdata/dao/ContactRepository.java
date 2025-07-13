package org.example.hibernatespringdata.dao;

import org.example.hibernatespringdata.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

//интерфейс, который дженерит другой интерфейс и есть Spring DATA JPA
//первый параметр наш класс как дженерик и Long
//содержит все методы для работы с БД
public interface ContactRepository extends JpaRepository<User, Long> {
}
