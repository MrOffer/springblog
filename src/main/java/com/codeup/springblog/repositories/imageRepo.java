package com.codeup.springblog.repositories;

import com.codeup.springblog.models.PostImage;
import org.springframework.data.jpa.repository.JpaRepository;



public interface imageRepo extends JpaRepository <PostImage, Long> {
}
