package br.com.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.model.User;


public interface UserRepository extends JpaRepository<User, Long> {

	Optional<User> findByUsername(String username);

	Optional<User> findById(int id);

	Boolean existsByUsername(String username);


	@Query(value =  "select * from usuarios u left join user_roles ur on ur.user_id = u.id left join roles r on r.id = ur.role_id where r.name = \"ROLE_OPERADOR\"", nativeQuery = true)
	List<User> listarOperadores ();
	
}

