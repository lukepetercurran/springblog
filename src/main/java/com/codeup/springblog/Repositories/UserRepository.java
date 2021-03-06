package com.codeup.springblog.Repositories;

import com.codeup.springblog.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findById(long id);

    UserRepository findByUsername(String username);
}