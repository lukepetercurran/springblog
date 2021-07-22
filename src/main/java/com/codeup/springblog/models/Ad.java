package com.codeup.springblog.models;

import javax.persistence.*;

@Entity
@Table(name="ads")
public class Ad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 140)
    private String title;

    @Column(nullable = false)
    private String description;
}
