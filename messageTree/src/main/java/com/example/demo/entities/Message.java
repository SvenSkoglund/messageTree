package com.example.demo.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity // This tells Hibernate to make a table out of this class
public class Message {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	private String content;

	@OneToOne
	@JoinColumn(name = "parentID")
	@JsonIgnore
	private Message parentMessage;

	@OneToMany
	@JoinColumn(name = "parentID") // we need to duplicate the physical information
	private List<Message> childMessages;

	private Integer likes;

	private Date timestamp;

//	@JsonProperty
//	private Boolean hasParent;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Message getParentMessage() {
		return parentMessage;
	}

	public void setParentMessage(Message parentMessage) {
		this.parentMessage = parentMessage;
	}

	public List<Message> getChildMessages() {
		return childMessages;
	}

	public void setChildMessages(List<Message> childMessages) {
		if (childMessages == null) {
			childMessages = new ArrayList<Message>();
		}
		this.childMessages = childMessages;
	}

	public Integer getLikes() {
		return likes;
	}

	public void setLikes(Integer likes) {
		this.likes = likes;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

}
