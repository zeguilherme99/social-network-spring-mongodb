package com.learning.socialnetwork.dto;

import java.io.Serializable;
import java.time.Instant;

public class CommentDTO implements Serializable {

    private String text;
    private Instant moment;
    private AuthorDTO author;

    public CommentDTO() {
    }

    public CommentDTO(String text, Instant moment, AuthorDTO author) {
        this.text = text;
        this.moment = moment;
        this.author = author;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Instant getMoment() {
        return moment;
    }

    public void setMoment(Instant moment) {
        this.moment = moment;
    }

    public AuthorDTO getAuthor() {
        return author;
    }

    public void setAuthor(AuthorDTO author) {
        this.author = author;
    }
}
