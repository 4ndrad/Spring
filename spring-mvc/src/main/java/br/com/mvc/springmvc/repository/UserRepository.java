package br.com.mvc.springmvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.mvc.springmvc.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, String>{
	User findByUsername(String username);
}
