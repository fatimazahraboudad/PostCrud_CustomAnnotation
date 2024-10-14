package com.example.ProjectWithCustomAnnotation.aspect;


import com.example.ProjectWithCustomAnnotation.Annotation.ValidatePostFields;
import com.example.ProjectWithCustomAnnotation.dto.PostDto;
import com.example.ProjectWithCustomAnnotation.exception.FieldEmptyException;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
@Slf4j
@Aspect
@Component
public class PostFieldValidatorAspect {

//    @Pointcut("@annotation(ValidatePostFields)")
//    public void validatePostFieldsPointcut() {}
//
//    @Before("validatePostFieldsPointcut()")
    @Around("@annotation(validatePostFields)")
    public void validatePostFields(ProceedingJoinPoint joinPoint, ValidatePostFields validatePostFields) throws Throwable {
        Object[] args = joinPoint.getArgs();

        for (Object arg : args) {
            if (arg instanceof PostDto) {
                PostDto postDto = (PostDto) arg;

                if (postDto.getName() == null || postDto.getName().isEmpty()) {
                    log.error("Post name must not be empty");
                    throw new FieldEmptyException();
                }

                if (postDto.getAuthor() == null || postDto.getAuthor().isEmpty()) {
                    log.error("Post author must not be empty");
                    throw new FieldEmptyException();
                }
            }
        }}

    }


