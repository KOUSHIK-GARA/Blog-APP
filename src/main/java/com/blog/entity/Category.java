package com.blog.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="Categories")
public class Category {
    @Id
    @Column(name="id")
    private String categoryId;
    @Column(name="name")
    private String categoryName;
    @Column(name="description")
    private String categoryDescription;
}
