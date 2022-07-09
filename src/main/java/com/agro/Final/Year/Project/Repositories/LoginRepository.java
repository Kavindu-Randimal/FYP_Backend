package com.agro.Final.Year.Project.Repositories;

import com.agro.Final.Year.Project.Models.Dto.LoginUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LoginRepository extends JpaRepository<LoginUser, Integer> {

    @Query(value = "SELECT * FROM login_user u WHERE u.user_email = :email",
            nativeQuery = true)
    List<LoginUser> findByEmail(@Param("email") String email);
}
