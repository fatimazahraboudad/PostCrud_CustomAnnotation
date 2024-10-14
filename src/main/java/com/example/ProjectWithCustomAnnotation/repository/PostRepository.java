package com.example.ProjectWithCustomAnnotation.repository;

import com.example.ProjectWithCustomAnnotation.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post,String> {
}
