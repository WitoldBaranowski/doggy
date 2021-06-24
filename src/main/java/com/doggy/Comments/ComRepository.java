package com.doggy.Comments;

import com.doggy.DatabaseCon.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ComRepository extends JpaRepository<Comments,Long> {
    @Query("SELECT s FROM Comments s where s.id = ?1")
    Optional<Comments> findCommentByid(Long id);

}
