package com.servme.todoapp.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.servme.todoapp.constant.TodoStatus;
import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "todo_item")
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class TodoItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private Timestamp datetime;
    private TodoStatus status;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn
    private Category category;

    @JoinColumn(name = "user_id", referencedColumnName = "id", table = "user")
    private long userId;

    @Transient
    private Long categoryId;
}

