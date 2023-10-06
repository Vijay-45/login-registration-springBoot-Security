package dev.Vijay.loginregistrationspringBootsecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.Vijay.loginregistrationspringBootsecurity.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	User findByEmail(String username);
}
