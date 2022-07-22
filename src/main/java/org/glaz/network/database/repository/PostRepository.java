package org.glaz.network.database.repository;

import org.glaz.network.database.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {

}
