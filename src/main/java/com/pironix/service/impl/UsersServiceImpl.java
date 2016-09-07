package com.pironix.service.impl;

import com.pironix.model.Users;
import com.pironix.repository.UserRepository;
import com.pironix.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;

/**
 * The UsersServiceImpl class
 * <p>
 * Created by ibrahim
 *
 * @author ibrahim KARAYEL
 * @version 1.0
 * @since 9/3/2016.
 */
@Service
@Transactional
public class UsersServiceImpl implements UsersService {

    @Autowired
    protected UserRepository userRepository;

    /**
     * @see UsersService#saveUser(Users)
     */
    @Override
    public Users saveUser(Users users) {
        return userRepository.save(users);
    }

    /**
     * @see UsersService#deleteUser(int)
     */
    @Override
    public Boolean deleteUser(int id) {
        Users user = userRepository.findOne(id);
        if (user != null) {
            userRepository.delete(user);
            return true;
        }
        return false;
    }

    /**
     * @see UsersService#editUser(Users)
     */
    @Override
    public Users editUser(Users users) {
        return userRepository.save(users);
    }

    /**
     * @see UsersService#findUsers(int)
     */
    @Override
    public Users findUsers(int id) {
        return userRepository.findOne(id);
    }

    /**
     * @see UsersService#findByUsername(String)
     */
    @Override
    public Users findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    /**
     * @see UsersService#findByEmail(String)
     */
    @Override
    public Users findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    /**
     * @see UsersService#getAllUsers()
     */
    @Override
    public Collection<Users> getAllUsers() {
        Iterable<Users> itr = userRepository.findAll();
        return (Collection<Users>) itr;
    }
}
