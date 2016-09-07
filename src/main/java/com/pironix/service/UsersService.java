package com.pironix.service;

import com.pironix.model.Users;

import java.util.Collection;

/**
 * The UsersService interface
 * <p>
 * Created by ibrahim
 *
 * @author ibrahim KARAYEL
 * @version 1.0
 * @since 9/3/2016.
 */
public interface UsersService {

    /**
     * @param users The saved user
     * @return saved User object
     */
    Users saveUser(Users users);

    /**
     * @param id user id
     * @return <tt>true</tt> if User object  deleted
     */
    Boolean deleteUser(int id);


    /**
     * @param users edited User object
     * @return edited User
     */
    Users editUser(Users users);

    /**
     * @param id User obejct id
     * @return User object
     */
    Users findUsers(int id);

    /**
     * @param username The User name
     * @return User by  Name
     */
    Users findByUsername(String username);

    /**
     * @param email User email
     * @return User by Email
     */
    Users findByEmail(String email);

    /**
     * @return all Users
     */
    Collection<Users> getAllUsers();
}
