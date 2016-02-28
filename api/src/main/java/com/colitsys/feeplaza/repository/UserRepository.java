package com.colitsys.feeplaza.repository;

import com.colitsys.feeplaza.model.User;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * Default user repository.
 */
@Repository
public interface UserRepository extends PagingAndSortingRepository<User, Long> {
    User findByEmail(final String email);

    User findByMobile(final Long mobile);
}
