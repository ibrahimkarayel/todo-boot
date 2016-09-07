package com.pironix.repository;

import com.pironix.model.Todo;
import com.pironix.model.Users;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 * *The TodoRepository interface
 * <p>
 * Created by ibrahim
 *
 * @author ibrahim KARAYEL
 * @version 1.0
 * @since 9/3/2016.
 */

public interface TodoRepository extends CrudRepository<Todo, Integer> {

    /**
     * @param status user status
     * @return all todos by status
     */
    @Query("from Todo t where t.status=:status")
    public Iterable<Todo> findByStatus(@Param("status") String status);

    /**
     * @param userId user id
     * @param status user status
     * @return all user todos by status and user_id
     */
    @Query("from Todo t where t.userId=:userId and  t.status=:status")
    public Iterable<Todo> findByUserIdStatus(@Param("userId") int userId, @Param("status") String status);


}