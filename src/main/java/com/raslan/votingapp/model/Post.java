package com.raslan.votingapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;

@Entity
public class Post {

    @Id
    private Long id;

    private String text;
    private String posttype;
    private Long photo_range_1;
    private Long photo_range_2;
    private Date post_date;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getPosttype() {
        return posttype;
    }

    public void setPosttype(String posttype) {
        this.posttype = posttype;
    }

    public Long getPhoto_range_1() {
        return photo_range_1;
    }

    public void setPhoto_range_1(Long photo_range_1) {
        this.photo_range_1 = photo_range_1;
    }

    public Long getPhoto_range_2() {
        return photo_range_2;
    }

    public void setPhoto_range_2(Long photo_range_2) {
        this.photo_range_2 = photo_range_2;
    }

    public Date getPost_date() {
        return post_date;
    }

    public void setPost_date(Date post_date) {
        this.post_date = post_date;
    }
}
