package com.API.tasks.infrastructure.repository;

import com.API.tasks.infrastructure.entitys.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserRepo extends JpaRepository<UserEntity, String> {
UserDetails findByLogin(String login);
}
