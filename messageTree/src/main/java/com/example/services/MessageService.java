package com.example.services;

import java.util.List;

import com.example.entities.Message;

public interface MessageService {

	public List<Message> index();

	public Message create(Message message);

	public Message update(Message message);

	public void destroy(int id);

}
