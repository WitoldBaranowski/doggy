package com.doggy.Comments;


import javax.persistence.*;

@Entity
@Table(name="comments")
public class Comments {
    @Id
    @SequenceGenerator(name = "coms_sequence", sequenceName = "coms_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "coms_sequence")
    private Long id;
    private String doggolink;
    private String username;
    private String comment;


    public Comments(String doggolink, String username, String comment) {
        this.doggolink = doggolink;
        this.username = username;
        this.comment = comment;
    }

    public Comments() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDoggolink() {
        return doggolink;
    }

    public void setDoggolink(String doggolink) {
        this.doggolink = doggolink;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
