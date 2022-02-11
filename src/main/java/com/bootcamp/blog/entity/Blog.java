package com.bootcamp.blog.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "blog")
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Blog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "author_id")
    @NotNull
    private Author author;
    @NotNull
    @NotEmpty
    private String name;
    private String description;
    private String url;
    private String status;

}
