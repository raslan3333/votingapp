package com.raslan.votingapp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class SingleChoice {

    @Id
    @GeneratedValue
    private Long id;

    private String singleChoiceText;
    private Long times;
    private Long postId;

    public SingleChoice() {
    }

    public SingleChoice(String singleChoiceText, Long times, Long postId) {
        this.singleChoiceText = singleChoiceText;
        this.times = times;
        this.postId = postId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSingleChoiceText() {
        return singleChoiceText;
    }

    public void setSingleChoiceText(String singleChoiceText) {
        this.singleChoiceText = singleChoiceText;
    }

    public Long getTimes() {
        return times;
    }

    public void setTimes(Long times) {
        this.times = times;
    }

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }
}
