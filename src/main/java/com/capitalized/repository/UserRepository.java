package com.capitalized.repository;

import com.capitalized.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.UUID;

@Repository
public interface UserRepository extends CrudRepository<User, UUID> {

}