package com.example.ProjectWithCustomAnnotation.service;

import com.example.ProjectWithCustomAnnotation.dto.PostDto;
import com.example.ProjectWithCustomAnnotation.entity.Post;
import com.example.ProjectWithCustomAnnotation.exception.PostNotExistInStock;
import com.example.ProjectWithCustomAnnotation.mapper.PostMapper;
import com.example.ProjectWithCustomAnnotation.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService{

    private final PostRepository postRepository;
    private final PostMapper postMapper;

    @Override
    public PostDto addPost(PostDto postDto) {
        Post post= postMapper.PostDtoToPost(postDto);
        post.setId(UUID.randomUUID().toString());
        return postMapper.PostToPostDto(postRepository.save(post));
    }

    @Override
    public List<PostDto> getPosts() {
        return postMapper.PostToPostDto(postRepository.findAll());
    }

    @Override
    public PostDto getPostById(String id) {
        return postMapper.PostToPostDto(helper(id));
    }

    @Override
    public PostDto updatePost(PostDto postDto) {
        Post post =helper(postDto.getId());
        post.setAuthor(postDto.getAuthor());
        post.setName(postDto.getName());
        post.setDate(postDto.getDate());
        return postMapper.PostToPostDto(postRepository.save(post));
    }

    @Override
    public String deletePost(String id) {
        postRepository.delete(helper(id));
        return "post deleted successfully";
    }

    private Post helper(String id) {
        return postRepository.findById(id).orElseThrow( () ->new PostNotExistInStock());
    }
}
