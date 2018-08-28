package com.raslan.votingapp.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "multi_choice")
public class MultiChoice {

    @Id
    @GeneratedValue
    private Long id;

    private String multiChoiceText;
    private Long times;
    private Long postId;

    public MultiChoice() {
    }

    public MultiChoice(String multiChoiceText, Long times, Long postId) {
        this.multiChoiceText = multiChoiceText;
        this.times = times;
        this.postId = postId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMultiChoiceText() {
        return multiChoiceText;
    }

    public void setMultiChoiceText(String multiChoiceText) {
        this.multiChoiceText = multiChoiceText;
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
