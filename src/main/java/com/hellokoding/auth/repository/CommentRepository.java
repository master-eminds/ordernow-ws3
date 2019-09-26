package com.hellokoding.auth.repository;

import com.hellokoding.auth.model.Comment;
import com.hellokoding.auth.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long>{

}
