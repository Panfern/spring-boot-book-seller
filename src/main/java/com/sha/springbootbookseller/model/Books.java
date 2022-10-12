package com.sha.springbootbookseller.model;


import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name= "books")
public class Books {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "title" , length = 100, nullable = false)
    private String title;

    @Column(name = "description" , length = 1000, nullable = false)
    private String description;

    @Column(name ="author", length= 100, nullable = false)
    private String author;

    @Column(name = "price" , nullable = false)
    private Double price;

    @Column(name= "create_time", nullable = false)
    private LocalDateTime createTime;

}
