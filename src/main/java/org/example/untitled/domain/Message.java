package org.example.untitled.domain.Message;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // This tells Hibernate to make a table out of this class
public class Message {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    private String text;
    private String tag;

    public Message() {
    }
    public Message(String text, String tag) {
        this.text = text;
        this.tag = tag;
    }

    public void setText(String text) {
        this.text = text;
    }
    public String getText() {
        return text;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getID() {
        return id;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
    public String getTag() {
        return tag;
    }

}