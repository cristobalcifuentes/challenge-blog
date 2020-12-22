package com.cristobal.alkemy.models.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cristobal.alkemy.models.entity.Categories;

public interface ICategoriesRepository extends JpaRepository<Categories, Integer> {

}
