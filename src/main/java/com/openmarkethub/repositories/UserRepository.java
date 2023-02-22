package com.openmarkethub.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.openmarkethub.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
