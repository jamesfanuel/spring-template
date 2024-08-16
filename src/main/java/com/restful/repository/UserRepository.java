package com.restful.repository;

import com.restful.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findFirstByMemberUsername(String memberUsername);
    Optional<User> findFirstByToken(String token);

}
