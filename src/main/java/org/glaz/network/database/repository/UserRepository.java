package org.glaz.network.database.repository;

import com.querydsl.core.types.Predicate;
import org.glaz.network.database.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long>,
        FilterUserRepository,
        QuerydslPredicateExecutor<User> {

    Page<User> findAll(Predicate predicate, Pageable pageable);

    Optional<User> findByUsername(String username);
}
