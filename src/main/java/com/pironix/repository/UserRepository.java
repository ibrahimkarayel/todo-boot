package com.pironix.repository;

import com.pironix.model.Users;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by ibrahim
 *
 * @author ibrahim KARAYEL
 * @version 1.0
 * @since 9/3/2016.
 */
public interface UserRepository extends CrudRepository<Users, Integer> {
    Users findByUsername(String username);
    Users findByEmail(String email);
}