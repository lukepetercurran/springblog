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

    @OneToOne
    private AdImage adImage;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    public Ad() {
    }

    public Ad(long id, String title, String description, AdImage adImage, User user) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.adImage = adImage;
        this.user = user;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public AdImage getAdImage() {
        return adImage;
    }

    public void setAdImage(AdImage adImage) {
        this.adImage = adImage;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
