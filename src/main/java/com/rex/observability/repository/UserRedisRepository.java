package com.rex.observability.repository;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rex.observability.models.User;

@Repository
public interface UserRedisRepository extends  CrudRepository<User, UUID>  {

}
