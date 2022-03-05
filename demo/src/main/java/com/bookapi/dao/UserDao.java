package com.bookapi.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookapi.entities.User;
@Repository
public interface UserDao extends JpaRepository<User, String> {

}
