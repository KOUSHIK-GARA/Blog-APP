package com.blog.repository;
import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;


import com.blog.entity.*;

public interface PostRepo   extends JpaRepository<Post, Integer>
{
    List<Post> findByUser(User user);
    List<Post> findByCategory(Category category);
    List<Post> findByTitleContaining(String title);
    //List<Post> findByContentContaining(String keyword);
}