package com.example.ProjectWithCustomAnnotation.service;

import com.example.ProjectWithCustomAnnotation.dto.PostDto;

import java.util.List;

public interface PostService {

    PostDto addPost(PostDto postDto);
    List<PostDto> getPosts();
    PostDto getPostById(String id);

    PostDto updatePost(PostDto postDto);
    String deletePost(String id);
}
