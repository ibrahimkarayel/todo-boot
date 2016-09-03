package com.pironix.service;

import com.pironix.model.Users;

import java.util.Collection;

/**
 * Created by ibrahim
 *
 * @author ibrahim KARAYEL
 * @version 1.0
 * @since 9/3/2016.
 */
public interface UsersService {
    Users saveUser(Users users);

    Boolean deleteUser(int id);

    Users editUser(Users users);

    Users findUsers(int id);

    Users findByUsername(String username);

    Users findByEmail(String email);

    Collection<Users> getAllUsers();
}
