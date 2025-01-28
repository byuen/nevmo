package com.capitalized.repository;

import com.capitalized.model.Request;
import com.capitalized.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RequestRepository extends CrudRepository<Request, UUID> {
}
