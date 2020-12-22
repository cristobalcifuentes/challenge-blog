package com.cristobal.alkemy.models.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cristobal.alkemy.models.entity.Posts;

public interface IPostsRepository extends JpaRepository<Posts, Integer> {

}
