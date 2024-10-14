package com.example.ProjectWithCustomAnnotation.dto;

import com.example.ProjectWithCustomAnnotation.Validation.AddPost;
import com.example.ProjectWithCustomAnnotation.Validation.UpdatePost;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import lombok.*;

import java.util.Date;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PostDto {

    @Null(groups = AddPost.class, message = "id must be null for add operations")
    @NotNull(groups = UpdatePost.class, message = "id must not be null for update operations")
    private String id;
    private String name;
    private String author;
    private Date date;
}
