package com.example.ProjectWithCustomAnnotation.controller;

import com.example.ProjectWithCustomAnnotation.Annotation.RequestLogger;
import com.example.ProjectWithCustomAnnotation.Annotation.ValidatePostFields;
import com.example.ProjectWithCustomAnnotation.Validation.AddPost;
import com.example.ProjectWithCustomAnnotation.Validation.UpdatePost;
import com.example.ProjectWithCustomAnnotation.dto.PostDto;
import com.example.ProjectWithCustomAnnotation.mapper.PostMapper;
import com.example.ProjectWithCustomAnnotation.service.PostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.sql.Update;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/post")
@RequiredArgsConstructor
@Slf4j
public class PostController {

    private final PostService postService;

    @PostMapping
    @ValidatePostFields
    public ResponseEntity<PostDto> addPost(@Validated(AddPost.class) @RequestBody PostDto postDto) {
        return new ResponseEntity<>(postService.addPost(postDto), HttpStatus.CREATED);
    }

    @GetMapping
    @RequestLogger
    public ResponseEntity<List<PostDto>> getAllPosts() {
        log.info("Inside API method");
        return new ResponseEntity<>(postService.getPosts(),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @RequestLogger
    public ResponseEntity<PostDto> getPostById(@PathVariable String id) {
        log.info("Inside API method");
        return new ResponseEntity<>(postService.getPostById(id),HttpStatus.OK);
    }

    @PutMapping
    @ValidatePostFields
    public ResponseEntity<PostDto> updatePost(@Validated(UpdatePost.class) @RequestBody PostDto postDto) {
        return new ResponseEntity<>(postService.updatePost(postDto), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePost(@PathVariable String id) {
        return new ResponseEntity<>(postService.deletePost(id), HttpStatus.CREATED);
    }
}
