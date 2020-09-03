package com.study.auth.security.repository;

import com.study.auth.security.model.SecurityUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface SecurityUserRepository extends JpaRepository<SecurityUser, Long> {

    @Query("SELECT DISTINCT u FROM SecurityUser u INNER JOIN FETCH u.authorities AS authorities " +
            "WHERE u.username = :username")
    SecurityUser findByUsername(@Param("username") String username);

}
