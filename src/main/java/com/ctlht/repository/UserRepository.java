package com.ctlht.repository;

import com.ctlht.entity.UserEntity;
import com.ctlht.repository.custom.UserRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long>, UserRepositoryCustom {
    UserEntity findByEmail(String email);
}
