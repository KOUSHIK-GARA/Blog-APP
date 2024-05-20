package com.blog.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "comments")
@NoArgsConstructor
@Getter
@Setter
public class Comment
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int categoryId;

    private String content;

    @ManyToOne
    private Post post;

    @ManyToOne
    private User user;
}
