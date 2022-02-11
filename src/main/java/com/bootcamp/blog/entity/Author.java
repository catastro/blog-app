package com.bootcamp.blog.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "author")
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true)
    private Long id;
    private String name;
    private String email;
    private String phone;

    @Column(name = "birth_date")
    private Date birthDate;
}
