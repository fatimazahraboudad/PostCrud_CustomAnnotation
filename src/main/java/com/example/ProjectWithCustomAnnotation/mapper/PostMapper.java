package com.example.ProjectWithCustomAnnotation.mapper;

import com.example.ProjectWithCustomAnnotation.dto.PostDto;
import com.example.ProjectWithCustomAnnotation.entity.Post;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PostMapper {

    Post PostDtoToPost(PostDto postDto);
    PostDto PostToPostDto(Post post);
    List<Post> PostDtoToPost(List<PostDto> postDtos);
    List<PostDto> PostToPostDto(List<Post> posts);
}
