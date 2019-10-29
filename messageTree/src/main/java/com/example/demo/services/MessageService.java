package com.example.demo.services;

import java.util.List;

import com.example.demo.entities.Message;

public interface MessageService {

	public List<Message> index();

	public Message create(Message message);

	public Message update(Message message);

	public void destroy(int id);

}
