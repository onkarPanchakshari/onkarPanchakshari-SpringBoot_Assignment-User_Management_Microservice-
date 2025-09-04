package com.OnkarPanchakshariTask.Task.repository;

import com.OnkarPanchakshariTask.Task.entities.Role;
import com.OnkarPanchakshariTask.Task.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {


    Optional<User> findByEmail(String email);

    User findByRole(Role role);
}
