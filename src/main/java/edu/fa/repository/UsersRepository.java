package edu.fa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.fa.model.Users;

public interface UsersRepository extends JpaRepository<Users, String> {
	Users findByUserNameAndPassword(String userName, String password);
}
