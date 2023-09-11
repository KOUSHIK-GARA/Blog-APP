package com.blog.entity;

import com.blog.response.FetchUsersResponse;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="Roles")
public class Role {

    @Id
    @Column(name="id")
    String roleId;
    @Column(name="name")
    String roleName;
    @Column(name="description")
    String roleDescription;
}
